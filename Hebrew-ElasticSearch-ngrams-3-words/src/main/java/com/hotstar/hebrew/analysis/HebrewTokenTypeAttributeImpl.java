package com.hotstar.hebrew.analysis;

import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.AttributeReflector;

public class HebrewTokenTypeAttributeImpl extends AttributeImpl implements HebrewTokenTypeAttribute {
    private HebrewType type = HebrewType.Unknown;
    private boolean isExact = false;
    public void setType(HebrewType type) {
        this.type = type;
    }

    public HebrewType getType() {
        return type;
    }

    public boolean isExact() {
        return isExact;
    }

    public void setExact(boolean isExact) {
        this.isExact = isExact;
    }

    public void clear() {
        type = HebrewType.Unknown;
        isExact = false;
    }

    @Override
    public void reflectWith(AttributeReflector reflector) {
        reflector.reflect(KeywordAttribute.class, "isExact", isExact);
        reflector.reflect(KeywordAttribute.class, "type", type);
    }

    public void copyTo(AttributeImpl target) {
        ((HebrewTokenTypeAttribute) target).setType(type);
    }
}

