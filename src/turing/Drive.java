package turing;

import java.util.List;

public interface Drive {
    char right(int tape);
    char left(int tape);
    void setValue(int tape, String value);
}
