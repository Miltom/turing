package turing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 */
class Program {
    private Set<Integer> states;            //Q
    private Set<Character> symbols;         //SIGMA
    private List<HashMap> transitions;      //delta
    private Set<Integer> finalStates;       //F
    private Set<Character> tapeSymbols;     //GAMMA
    private int initialState;               //q0
    private final char BLANK;               //B
    private final int tapes;			    // number of tapes
    private final int tracks;				// tracks per tape


    public Program(char blank, int tapes, int tracks){
        this.BLANK = '_';
        this.states = new CopyOnWriteArraySet<Integer>();
        this.symbols = new CopyOnWriteArraySet<Character>();
        this.transitions = new ArrayList<HashMap>();
        this.finalStates = new CopyOnWriteArraySet<Integer>();
        this.tapeSymbols = new CopyOnWriteArraySet<Character>();
        this.tapes = tapes;
        this.tracks = tracks;
    }

    public int getTapes() {
		return tapes;
	}

	public int getTracks() {
		return tracks;
	}

	public Program(char blank, int tapes, int tracks,
    		Set<Integer> states, Set<Character> symbols,
                   List<HashMap> transitions, Set<Integer> finalStates,
                   Set<Character> tapeSymbols, int initialState) {
        this.states = states;
        this.symbols = symbols;
        this.transitions = transitions;
        this.finalStates = finalStates;
        this.tapeSymbols = tapeSymbols;
        this.initialState = initialState;
        this.BLANK = blank;
        this.tapes = tapes;
        this.tracks = tracks;
    }


    public Set<Integer> getStates() {
        return states;
    }
    public void setStates(Iterable<Integer> states) {
        for (Integer state:states) {
            this.states.add(state);
        }
    }
    public Set<Character> getSymbols() {
        return symbols;
    }
    public void setSymbols(Iterable<Character> symbols) {
        for(Character symbol:symbols) {
            this.symbols.add(symbol);
        }
    }

    public Set<Integer> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(Iterable<Integer> finalStates) {
        for (int state:finalStates){
            this.finalStates.add(state);
        }
    }

    public Set<Character> getTapeSymbols() {
        return tapeSymbols;
    }

    public void setTapeSymbols(Iterable<Character> tapeSymbols) {
        for (Character symbol:tapeSymbols){
            this.tapeSymbols.add(symbol);
        }
    }

    public int getInitialState() {
        return initialState;
    }

    public void setInitialState(int initialState) {
        this.initialState = initialState;
    }

    public char getBlank() {
        return BLANK;
    }

    public List<HashMap> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<HashMap> transitions) {
        this.transitions = transitions;
    }

    public void validate() throws VerifyError {
        for (Integer state : finalStates) {
            if (!states.contains(state)) {
                throw new VerifyError("Final state " + state + " not in states.");
            }
        }
        if (!states.contains(initialState)) {
            throw new VerifyError("Initial state " + initialState + " not in states.");
        }
        if(states.size() < 2) {
            throw new VerifyError("There are less than 2 states.");
        }
        if(symbols.size() < 1) {
            throw new VerifyError("There are no symbols.");
        }
        // can be extended
    }

}
