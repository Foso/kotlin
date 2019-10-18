/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.intentions;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/concatenatedStringGenerator")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class ConcatenatedStringGeneratorTestGenerated extends AbstractConcatenatedStringGeneratorTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    public void testAllFilesPresentInConcatenatedStringGenerator() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/concatenatedStringGenerator"), Pattern.compile("^([\\w\\-_]+)\\.kt$"), true);
    }

    @TestMetadata("constants.kt")
    public void testConstants() throws Exception {
        runTest("idea/testData/concatenatedStringGenerator/constants.kt");
    }

    @TestMetadata("constants2.kt")
    public void testConstants2() throws Exception {
        runTest("idea/testData/concatenatedStringGenerator/constants2.kt");
    }

    @TestMetadata("simple.kt")
    public void testSimple() throws Exception {
        runTest("idea/testData/concatenatedStringGenerator/simple.kt");
    }

    @TestMetadata("stringtemplate.kt")
    public void testStringtemplate() throws Exception {
        runTest("idea/testData/concatenatedStringGenerator/stringtemplate.kt");
    }

    @TestMetadata("stringtemplateWithConstant.kt")
    public void testStringtemplateWithConstant() throws Exception {
        runTest("idea/testData/concatenatedStringGenerator/stringtemplateWithConstant.kt");
    }

    @TestMetadata("variables.kt")
    public void testVariables() throws Exception {
        runTest("idea/testData/concatenatedStringGenerator/variables.kt");
    }
}
