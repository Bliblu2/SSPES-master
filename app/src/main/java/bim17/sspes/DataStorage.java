package bim17.sspes;

class DataStorage {
    //Variablen
    private String slot1name = "Player 1";
    private String slot2name = "Player 2";
    private String slot3name = "Player 3";
    private String slot4name = "Player 4";
    private String slot5name = "Player 5";
    private int slot1losses = 0;
    private int slot1wins = 0;
    private int slot1draws = 0;
    private int slot2losses = 0;
    private int slot2wins = 0;
    private int slot2draws = 0;
    private int slot3losses = 0;
    private int slot3wins = 0;
    private int slot3draws = 0;
    private int slot4losses = 0;
    private int slot4wins = 0;
    private int slot4draws = 0;
    private int slot5losses = 0;
    private int slot5wins = 0;
    private int slot5draws = 0;

    private int LeonardLosses = 0;
    private int LeonardWins = 0;
    private int LeonardDraws = 0;
    private int PennyLosses = 0;
    private int PennyWins = 0;
    private int PennyDraws = 0;
    private int SheldonLosses = 0;
    private int SheldonWins = 0;
    private int SheldonDraws = 0;

    private int rockWins = 0;
    private int rockLosses = 0;
    private int rockDraws = 0;
    private int paperWins = 0;
    private int paperLosses = 0;
    private int paperDraws = 0;
    private int scissorsWins = 0;
    private int scissorsLosses = 0;
    private int scissorsDraws = 0;
    private int lizardWins = 0;
    private int lizardLosses = 0;
    private int lizardDraws = 0;
    private int spockWins = 0;
    private int spockLosses = 0;
    private int spockDraws = 0;


    private int player1;    //1-5 nach Playerslots
    private int player2;    //1-8: 1-5 nach Playerslots, 6 Leonard, 7 Penny, 8 Sheldon


    /*Methode, die einen Spieler loescht
        @param int slotID //Die ID des Slots, der geloescht wird
        */
    public void deleteSlot(int slotID) {
        switch (slotID) {
            case 1:
                slot1name = "Player 1"; //??? das kann man noch durch einen String ersetzen
                slot1losses = 0;
                slot1wins = 0;
                slot1draws = 0;
                break;
            case 2:
                slot2name = "Player 2";
                slot2losses = 0;
                slot2wins = 0;
                slot2draws = 0;
                break;
            case 3:
                slot3name = "Player 3";
                slot3losses = 0;
                slot3wins = 0;
                slot3draws = 0;
                break;
            case 4:
                slot4name = "Player 4";
                slot4losses = 0;
                slot4wins = 0;
                slot4draws = 0;
                break;
            case 5:
                slot5name = "Player 5";
                slot5losses = 0;
                slot5wins = 0;
                slot5draws = 0;
                break;
            default:
                break;
        }
    }

    // Getter und Setter der Variablen
    public String getSlot1name() {
        return slot1name;
    }

    public void setSlot1name(String slot1name) {
        this.slot1name = slot1name;
    }

    public String getSlot2name() {
        return slot2name;
    }

    public void setSlot2name(String slot2name) {
        this.slot2name = slot2name;
    }

    public String getSlot3name() {
        return slot3name;
    }

    public void setSlot3name(String slot3name) {
        this.slot3name = slot3name;
    }

    public String getSlot4name() {
        return slot4name;
    }

    public void setSlot4name(String slot4name) {
        this.slot4name = slot4name;
    }

    public String getSlot5name() {
        return slot5name;
    }

    public void setSlot5name(String slot5name) {
        this.slot5name = slot5name;
    }

    public int getSlot1losses() {
        return slot1losses;
    }

    public void setSlot1losses(int slot1losses) {
        this.slot1losses = slot1losses;
    }

    public int getSlot1wins() {
        return slot1wins;
    }

    public void setSlot1wins(int slot1wins) {
        this.slot1wins = slot1wins;
    }

    public int getSlot1draws() {
        return slot1draws;
    }

    public void setSlot1draws(int slot1draws) {
        this.slot1draws = slot1draws;
    }

    public int getSlot2losses() {
        return slot2losses;
    }

    public void setSlot2losses(int slot2losses) {
        this.slot2losses = slot2losses;
    }

    public int getSlot2wins() {
        return slot2wins;
    }

    public void setSlot2wins(int slot2wins) {
        this.slot2wins = slot2wins;
    }

    public int getSlot2draws() {
        return slot2draws;
    }

    public void setSlot2draws(int slot2draws) {
        this.slot2draws = slot2draws;
    }

    public int getSlot3losses() {
        return slot3losses;
    }

    public void setSlot3losses(int slot3losses) {
        this.slot3losses = slot3losses;
    }

    public int getSlot3wins() {
        return slot3wins;
    }

    public void setSlot3wins(int slot3wins) {
        this.slot3wins = slot3wins;
    }

    public int getSlot3draws() {
        return slot3draws;
    }

    public void setSlot3draws(int slot3draws) {
        this.slot3draws = slot3draws;
    }

    public int getSlot4losses() {
        return slot4losses;
    }

    public void setSlot4losses(int slot4losses) {
        this.slot4losses = slot4losses;
    }

    public int getSlot4wins() {
        return slot4wins;
    }

    public void setSlot4wins(int slot4wins) {
        this.slot4wins = slot4wins;
    }

    public int getSlot4draws() {
        return slot4draws;
    }

    public void setSlot4draws(int slot4draws) {
        this.slot4draws = slot4draws;
    }

    public int getSlot5losses() {
        return slot5losses;
    }

    public void setSlot5losses(int slot5losses) {
        this.slot5losses = slot5losses;
    }

    public int getSlot5wins() {
        return slot5wins;
    }

    public void setSlot5wins(int slot5wins) {
        this.slot5wins = slot5wins;
    }

    public int getSlot5draws() {
        return slot5draws;
    }

    public void setSlot5draws(int slot5draws) {
        this.slot5draws = slot5draws;
    }

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public int getLeonardLosses() {
        return LeonardLosses;
    }

    public void setLeonardLosses(int leonardLosses) {
        LeonardLosses = leonardLosses;
    }

    public int getLeonardWins() {
        return LeonardWins;
    }

    public void setLeonardWins(int leonardWins) {
        LeonardWins = leonardWins;
    }

    public int getLeonardDraws() {
        return LeonardDraws;
    }

    public void setLeonardDraws(int leonardDraws) {
        LeonardDraws = leonardDraws;
    }

    public int getPennyLosses() {
        return PennyLosses;
    }

    public void setPennyLosses(int pennyLosses) {
        PennyLosses = pennyLosses;
    }

    public int getPennyWins() {
        return PennyWins;
    }

    public void setPennyWins(int pennyWins) {
        PennyWins = pennyWins;
    }

    public int getPennyDraws() {
        return PennyDraws;
    }

    public void setPennyDraws(int pennyDraws) {
        PennyDraws = pennyDraws;
    }

    public int getSheldonLosses() {
        return SheldonLosses;
    }

    public void setSheldonLosses(int sheldonLosses) {
        SheldonLosses = sheldonLosses;
    }

    public int getSheldonWins() {
        return SheldonWins;
    }

    public void setSheldonWins(int sheldonWins) {
        SheldonWins = sheldonWins;
    }

    public int getSheldonDraws() {
        return SheldonDraws;
    }

    public void setSheldonDraws(int sheldonDraws) {
        SheldonDraws = sheldonDraws;
    }

    public int getRockWins() {
        return rockWins;
    }

    public void setRockWins(int rockWins) {
        this.rockWins = rockWins;
    }

    public int getRockLosses() {
        return rockLosses;
    }

    public void setRockLosses(int rockLosses) {
        this.rockLosses = rockLosses;
    }

    public int getRockDraws() {
        return rockDraws;
    }

    public void setRockDraws(int rockDraws) {
        this.rockDraws = rockDraws;
    }

    public int getPaperWins() {
        return paperWins;
    }

    public void setPaperWins(int paperWins) {
        this.paperWins = paperWins;
    }

    public int getPaperLosses() {
        return paperLosses;
    }

    public void setPaperLosses(int paperLosses) {
        this.paperLosses = paperLosses;
    }

    public int getPaperDraws() {
        return paperDraws;
    }

    public void setPaperDraws(int paperDraws) {
        this.paperDraws = paperDraws;
    }

    public int getScissorsWins() {
        return scissorsWins;
    }

    public void setScissorsWins(int scissorsWins) {
        this.scissorsWins = scissorsWins;
    }

    public int getScissorsLosses() {
        return scissorsLosses;
    }

    public void setScissorsLosses(int scissorsLosses) {
        this.scissorsLosses = scissorsLosses;
    }

    public int getScissorsDraws() {
        return scissorsDraws;
    }

    public void setScissorsDraws(int scissorsDraws) {
        this.scissorsDraws = scissorsDraws;
    }

    public int getLizardWins() {
        return lizardWins;
    }

    public void setLizardWins(int lizardWins) {
        this.lizardWins = lizardWins;
    }

    public int getLizardLosses() {
        return lizardLosses;
    }

    public void setLizardLosses(int lizardLosses) {
        this.lizardLosses = lizardLosses;
    }

    public int getLizardDraws() {
        return lizardDraws;
    }

    public void setLizardDraws(int lizardDraws) {
        this.lizardDraws = lizardDraws;
    }

    public int getSpockWins() {
        return spockWins;
    }

    public void setSpockWins(int spockWins) {
        this.spockWins = spockWins;
    }

    public int getSpockLosses() {
        return spockLosses;
    }

    public void setSpockLosses(int spockLosses) {
        this.spockLosses = spockLosses;
    }

    public int getSpockDraws() {
        return spockDraws;
    }

    public void setSpockDraws(int spockDraws) {
        this.spockDraws = spockDraws;
    }
}
