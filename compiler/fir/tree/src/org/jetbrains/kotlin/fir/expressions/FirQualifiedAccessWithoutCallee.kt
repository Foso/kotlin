/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.expressions

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.fir.visitors.*

/*
 * This file was generated automatically
 * DO NOT MODIFY IT MANUALLY
 */

interface FirQualifiedAccessWithoutCallee : FirStatement {
    override val psi: PsiElement?
    override val annotations: List<FirAnnotationCall>
    val safe: Boolean
    val explicitReceiver: FirExpression?
    val dispatchReceiver: FirExpression
    val extensionReceiver: FirExpression

    override fun <R, D> accept(visitor: FirVisitor<R, D>, data: D): R = visitor.visitQualifiedAccessWithoutCallee(this, data)

    fun <D> transformExplicitReceiver(transformer: FirTransformer<D>, data: D): FirQualifiedAccessWithoutCallee

    fun <D> transformDispatchReceiver(transformer: FirTransformer<D>, data: D): FirQualifiedAccessWithoutCallee

    fun <D> transformExtensionReceiver(transformer: FirTransformer<D>, data: D): FirQualifiedAccessWithoutCallee
}
