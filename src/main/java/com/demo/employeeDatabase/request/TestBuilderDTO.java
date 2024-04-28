package com.demo.employeeDatabase.request;

/**
 * Implementing builder pattern without using lombok
 */

/**
 *  In lombok we call :
 *  <CLASSNAME>.builder()......build()
 *  object.toBuilder().......build()
 *
 *  We will try to replicate that
 */
public class TestBuilderDTO {

    private String field1;

    private String field2;

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    //Private constructor to prevent instantiation
    private TestBuilderDTO() {
    }

    //Builder class
    public static class Builder {
        private String field1;
        private String field2;

        public Builder field1(String field1) {
            this.field1 = field1;
            return this;
        }

        public Builder field2(String field2) {
            this.field2 = field2;
            return this;
        }


        //build method
        public TestBuilderDTO build() {
            TestBuilderDTO testBuilderDTO = new TestBuilderDTO();
            testBuilderDTO.field1 = this.field1;
            testBuilderDTO.field2 = this.field2;
            return testBuilderDTO;
        }
    }


    //  object.toBuilder().......build()
    public Builder toBuilder() {
        return new Builder().field1(this.field1).field2(this.field2);
    }

    //  <CLASSNAME>.builder()......build()
    public static Builder builder() {
        return new Builder();
    }



}
