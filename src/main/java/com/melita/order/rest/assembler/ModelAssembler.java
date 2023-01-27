package com.melita.order.rest.assembler;

public interface ModelAssembler<In, Out> {
    Out assemble(In in);
}
