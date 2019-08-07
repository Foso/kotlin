/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.wasm.ast

fun WasmInstruction.toWat(ident: String = ""): String =
    "$ident($mnemonic${argument.toWat()}${operands.joinToString("") { " " + it.toWat("") }})"

fun WasmArgument.toWat(): String = when (this) {
    WasmArgument.None -> ""
    is WasmArgument.DeclarationReference -> " $$name"
    // Mozilla can't parse Uppercase constants
    is WasmArgument.Const<*> -> " $value".toLowerCase()
}

fun wasmModuleToWat(module: WasmModule): String =
    "(module\n${module.fields.joinToString("") { wasmModuleFieldToWat(it) + "\n" }})"

fun wasmFunctionToWat(function: WasmFunction): String {
    val watId = "$${function.name}"
    val watImport = function.importName?.let { importName -> " (import \"${importName.module}\" \"${importName.name}\")" } ?: ""
    val watLocals = function.locals.joinToString("") { "   " + wasmLocalToWat(it) + "\n" }
    val watParameters = function.parameters.joinToString("") { " " + wasmParameterToWat(it, function.importName == null) }
    val watResult = function.returnType?.let { type -> " (result ${type.mnemonic})" } ?: ""
    val watBody = function.instructions.joinToString("") { it.toWat("    ") + "\n" }
    return "  (func $watId$watImport$watParameters$watResult\n$watLocals$watBody  )"
}

fun wasmParameterToWat(parameter: WasmParameter, includeName: Boolean): String {
    val name = if (includeName) " $${parameter.name}" else ""

    return "(param$name ${parameter.type.mnemonic})"
}

fun wasmLocalToWat(local: WasmLocal): String =
    local.run { "(local $$name ${type.mnemonic})" }

fun wasmGlobalToWat(global: WasmGlobal): String {
    val watMut = if (global.isMutable) "mut " else ""
    val watInit = global.init?.toWat("") ?: ""
    return global.run { "  (global $$name ($watMut${type.mnemonic}) $watInit)" }
}

fun wasmExportToWat(export: WasmExport): String =
    export.run { "  (export \"$exportedName\" (${kind.keyword} $$wasmName))" }

fun wasmModuleFieldToWat(moduleField: WasmModuleField): String =
    when (moduleField) {
        is WasmFunction -> wasmFunctionToWat(moduleField)
        is WasmGlobal -> wasmGlobalToWat(moduleField)
        is WasmExport -> wasmExportToWat(moduleField)
        is WasmModuleFieldList -> moduleField.fields.joinToString("") { wasmModuleFieldToWat(it) + "\n" }
    }