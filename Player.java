public interface Player {

    public Move getMove();

    public String getToken();

    public void placeToken(Board board);

    public String getPrintableToken();

}
