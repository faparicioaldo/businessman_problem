package com.java.course.pipeline;

public interface Handler<I, O> {
	O process(I input);
}
