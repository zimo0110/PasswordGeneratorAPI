package com.example.passwordGenerator.src;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

public class GeneratorRequest {
    private boolean includeUpper;
    private boolean includeLower;
    private boolean includeNum;
    private boolean includeSym;
    private int length;

    @JsonCreator
    public GeneratorRequest(
            @JsonProperty("includeUpper") boolean includeUpper,
            @JsonProperty("includeLower") boolean includeLower,
            @JsonProperty("includeNum") boolean includeNum,
            @JsonProperty("includeSym") boolean includeSym,
            @JsonProperty("length") int length) {
        this.includeUpper = includeUpper;
        this.includeLower = includeLower;
        this.includeNum = includeNum;
        this.includeSym = includeSym;
        this.length = length;
    }

    public boolean getUpper() {
        return includeUpper;
    }

    public boolean getLower() {
        return includeLower;
    }

    public boolean getNum() {
        return includeNum;
    }

    public boolean getSym() {
        return includeSym;
    }

    public int getLength() {
        return length;
    }
}
