package src;

public interface Player {

    // get move of player from userinput in command line
    public Move getMove();

    // get current move of player saved as class member
    public Move getCurrentMove();

    // get token of player
    public String getToken();

    // get no formatting string represenation of token with single char as String
    public String getPrintableToken();

    // get name of player
    public String getName();

}
