package com.data.processors;

import com.data.Corpus;
import com.data.Document.IDocument;
import com.data.Document.TextDocument;

import java.util.List;
import java.util.Map;

/**
 * This  is an interface for a feature processor which can process a document using different feature types as defined by
 * the interface.
 * Created by george on 12/21/13.
 */
public interface  IFeatureProcessor {
    public Map<String, Double> process(TextDocument document, Corpus corpus);
    public Map<String,Double> process(List<TextDocument> documentSet,Corpus corpus);
}
