package com.data.processors;

import com.data.Document.TextDocument;

/**
 * The Language Processor is meant to try to decide what language a document is most likely to
 * be using some sort of inference and background information. This processor is still highly
 * experimental and a slow work in progress. Initial versions shall compare TextDocument objects
 * terms to a series of dictionaries in multiple languages to try to determine the origin of a given document.
 */
public class LanguageProcessor {
    public void init(){}

    /**
     * The process method will take a given text document and attempt to identify
     * the langauge that this document is in.
     * @param document
     */
    public void process(TextDocument document){};
}
