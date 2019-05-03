package bim17.sspes;
/* Class for a temporal data storage. It contains statistical data for players, wins, losses, draws
 * and player names in variables. It also contains methods to access, change or delete these
 * variables.
 * @author Carolin Ludwig, Sabrina Krietsch, Lena Glaesener
 * @version 1.0 5.2019
 */
class DataStorage {
    //variables for player names = slots
    private String slot1name = "Player 1";
    private String slot2name = "Player 2";
    private String slot3name = "Player 3";
    private String slot4name = "Player 4";
    private String slot5name = "Player 5";

    //variables for wins, losses and draws of human players
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

    //variables for computer wins, losses and draws
    private int leonardLosses = 0;
    private int leonardWins = 0;
    private int leonardDraws = 0;
    private int pennyLosses = 0;
    private int pennyWins = 0;
    private int pennyDraws = 0;
    private int sheldonLosses = 0;
    private int sheldonWins = 0;
    private int sheldonDraws = 0;

    //variables for element wins, losses and draws
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

    //variables that store which player (1 or 2) uses which player slot.
    //may be 1-5 depending on player slot
    private int player1;
    //may be 1-8; 1-5 for human players 6 for computer Leonard, 7 for computer Penny and 8 for
    //computer Sheldon.
    private int player2;    //1-8: 1-5 nach Playerslots, 6 Leonard, 7 Penny, 8 Sheldon


    /* Method that erases a slot name from a slot. All the statistical data for wins, losses and
     * draws is also cleared.
     * @param int slotID ID of the slot that should be cleared.
     */
    void deleteSlot(int slotID) {
        switch (slotID) {
            case 1:
                slot1name = "Player 1";
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
    /* Getter for variable slot1name.
     * @return String slot1name Name of the first slot.
     */
    String getSlot1name() {
        return slot1name;
    }
    /* Setter for variable slot1name.
     * @param String slot1name Name that the first slot should be.
     */
    void setSlot1name(String slot1name) {
        this.slot1name = slot1name;
    }

    /* Getter for variable slot2name.
     * @return String slot2name Name of the second slot.
     */
    String getSlot2name() {
        return slot2name;
    }

    /* Setter for variable slot2name.
     * @param String slot2name Name that the second slot should be.
     */
    void setSlot2name(String slot2name) {
        this.slot2name = slot2name;
    }

    /* Getter for variable slot3name.
     * @return String slot3name Name of the third slot.
     */
    String getSlot3name() {
        return slot3name;
    }

    /* Setter for variable slot3name.
     * @param String slot3name Name that the third slot should be.
     */
    void setSlot3name(String slot3name) {
        this.slot3name = slot3name;
    }

    /* Getter for variable slot4name.
     * @return String slot4name Name of the fourth slot.
     */
    String getSlot4name() {
        return slot4name;
    }

    /* Setter for variable slot4name.
     * @param String slot4name Name that the fourth slot should be.
     */
    void setSlot4name(String slot4name) {
        this.slot4name = slot4name;
    }

    /* Getter for variable slot5name.
     * @return String slot5name Name of the fifth slot.
     */
    String getSlot5name() {
        return slot5name;
    }

    /* Setter for variable slot5name.
     * @param String slot5name Name that the fifth slot should be.
     */
    void setSlot5name(String slot5name) {
        this.slot5name = slot5name;
    }

    /* Getter for variable losses of 1. slot.
     * @return int slot1losses Number of losses of slot 1.
     */
    int getSlot1losses() {
        return slot1losses;
    }

    /* Setter for variable losses of 1. slot.
     * @param int slot1losses Number of times that the first slot lost.
     */
    void setSlot1losses(int slot1losses) {
        this.slot1losses = slot1losses;
    }

    /* Getter for variable wins of 1. slot.
     * @return int slot1wins Number of wins of slot 1.
     */
    int getSlot1wins() {
        return slot1wins;
    }

    /* Setter for variable wins of 1. slot.
     * @param int slot1wins Number of times that the first slot won.
     */
    void setSlot1wins(int slot1wins) {
        this.slot1wins = slot1wins;
    }

    /* Getter for variable draws of 1. slot.
     * @return int slot1draws Number of draws of slot 1.
     */
    int getSlot1draws() {
        return slot1draws;
    }

    /* Setter for variable draws of 1. slot.
     * @param int slot1draws Number of times that the first slot played a draw.
     */
    void setSlot1draws(int slot1draws) {
        this.slot1draws = slot1draws;
    }

    /* Getter for variable losses of 2. slot.
     * @return int slot2losses Number of losses of slot 2.
     */
    int getSlot2losses() {
        return slot2losses;
    }

    /* Setter for variable losses of 2. slot.
     * @param int slot2losses Number of times that the second slot lost.
     */
    void setSlot2losses(int slot2losses) {
        this.slot2losses = slot2losses;
    }

    /* Getter for variable wins of 2. slot.
     * @return int slot2wins Number of wins of slot 2.
     */
    int getSlot2wins() {
        return slot2wins;
    }

    /* Setter for variable wins of 2. slot.
     * @param int slot2wins Number of times that the second slot lost.
     */
    void setSlot2wins(int slot2wins) {
        this.slot2wins = slot2wins;
    }

    /* Getter for variable draws of 2. slot.
     * @return int slot2draws Number of draws of slot 2.
     */
    int getSlot2draws() {
        return slot2draws;
    }

    /* Setter for variable draws of 2. slot.
     * @param int slot2draws Number of times that the second slot lost.
     */
    void setSlot2draws(int slot2draws) {
        this.slot2draws = slot2draws;
    }

    /* Getter for variable losses of 3. slot.
     * @return int slot3losses Number of losses of slot 3.
     */
    int getSlot3losses() {
        return slot3losses;
    }

    /* Setter for variable losses of 3. slot.
     * @param int slot3losses Number of times that the third slot lost.
     */
    void setSlot3losses(int slot3losses) {
        this.slot3losses = slot3losses;
    }

    /* Getter for variable wins of 3. slot.
     * @return int slot3wins Number of wins of slot 3.
     */
    int getSlot3wins() {
        return slot3wins;
    }

    /* Setter for variable wins of 3. slot.
     * @param int slot3wins Number of times that the third slot lost.
     */
    void setSlot3wins(int slot3wins) {
        this.slot3wins = slot3wins;
    }

    /* Getter for variable draws of 3. slot.
     * @return int slot3draws Number of draws of slot 3.
     */
    int getSlot3draws() {
        return slot3draws;
    }

    /* Setter for variable draws of 3. slot.
     * @param int slot3draws Number of times that the third slot lost.
     */
    void setSlot3draws(int slot3draws) {
        this.slot3draws = slot3draws;
    }

    /* Getter for variable losses of 4. slot.
     * @return int slot4losses Number of losses of slot 4.
     */
    int getSlot4losses() {
        return slot4losses;
    }

    /* Setter for variable losses of 4. slot.
     * @param int slot4losses Number of times that the fourth slot lost.
     */
    void setSlot4losses(int slot4losses) {
        this.slot4losses = slot4losses;
    }

    /* Getter for variable wins of 4. slot.
     * @return int slot4wins Number of wins of slot 4.
     */
    int getSlot4wins() {
        return slot4wins;
    }

    /* Setter for variable wins of 4. slot.
     * @param int slot4wins Number of times that the fourth slot lost.
     */
    void setSlot4wins(int slot4wins) {
        this.slot4wins = slot4wins;
    }

    /* Getter for variable draws of 4. slot.
     * @return int slot4draws Number of draws of slot 4.
     */
    int getSlot4draws() {
        return slot4draws;
    }

    /* Setter for variable draws of 4. slot.
     * @param int slot4draws Number of times that the fourth slot lost.
     */
    void setSlot4draws(int slot4draws) {
        this.slot4draws = slot4draws;
    }

    /* Getter for variable losses of 5. slot.
     * @return int slot5losses Number of losses of slot 5.
     */
    int getSlot5losses() {
        return slot5losses;
    }

    /* Setter for variable losses of 5. slot.
     * @param int slot5losses Number of times that the fifth slot lost.
     */
    void setSlot5losses(int slot5losses) {
        this.slot5losses = slot5losses;
    }

    /* Getter for variable wins of 5. slot.
     * @return int slot5wins Number of wins of slot 5.
     */
    int getSlot5wins() {
        return slot5wins;
    }

    /* Setter for variable wins of 5. slot.
     * @param int slot5wins Number of times that the fifth slot lost.
     */
    void setSlot5wins(int slot5wins) {
        this.slot5wins = slot5wins;
    }

    /* Getter for variable draws of 5. slot.
     * @return int slot5draws Number of draws of slot 5.
     */
    int getSlot5draws() {
        return slot5draws;
    }

    /* Setter for variable draws of 5. slot.
     * @param int slot5draws Number of times that the fifth slot lost.
     */
    void setSlot5draws(int slot5draws) {
        this.slot5draws = slot5draws;
    }

    /* Getter for variable player One.
     * @return int player1 Number of slot that player 1 uses.
     */
    int getPlayer1() {
        return player1;
    }

    /* Setter for variable player One.
     * @param int player1 Number of slot that player 1 uses.
     */
    void setPlayer1(int player1) {
        this.player1 = player1;
    }

    /* Getter for variable player Two.
     * @return int player2 Number of slot that player 2 uses.
     */
    int getPlayer2() {
        return player2;
    }

    /* Setter for variable player Two.
     * @param int player2 Number of slot that player 2 uses.
     */
    void setPlayer2(int player2) {
        this.player2 = player2;
    }

    /* Getter for variable leonardLosses.
     * @return int leonardLosses Number of losses of Leonard.
     */
    int getLeonardLosses() {
        return leonardLosses;
    }

    /* Setter for variable leonardLosses.
     * @param int leonardLosses Number of times Leonard lost.
     */
    void setLeonardLosses(int leonardLosses) {
        this.leonardLosses = leonardLosses;
    }

    /* Getter for variable leonardWins.
     * @return int leonardWins Number of times Leonard wins.
     */
    int getLeonardWins() {
        return leonardWins;
    }

    /* Setter for variable leonardWins.
     * @param int leonardWins Number of times Leonard wins.
     */
    void setLeonardWins(int leonardWins) {
        this.leonardWins = leonardWins;
    }

    /* Getter for variable leonardDraws.
     * @return int leonardDraws Number of times Leonard played draw.
     */
    int getLeonardDraws() {
        return leonardDraws;
    }

    /* Setter for variable leonardDraws.
     * @param int leonardDraws Number of times Leonard played draw.
     */
    void setLeonardDraws(int leonardDraws) {
        this.leonardDraws = leonardDraws;
    }

    /* Getter for variable pennyLosses.
     * @return int pennyLosses Number of losses of Penny.
     */
    int getPennyLosses() {
        return pennyLosses;
    }

    /* Setter for variable pennyLosses.
     * @param int pennyLosses Number of losses of Penny.
     */
    void setPennyLosses(int pennyLosses) {
        this.pennyLosses = pennyLosses;
    }

    /* Getter for variable pennyWins.
     * @return int pennyWins Number of wins of Penny.
     */
    int getPennyWins() {
        return pennyWins;
    }

    /* Setter for variable pennyWins.
     * @param int pennyWins Number of times Penny wins.
     */
    void setPennyWins(int pennyWins) {
        this.pennyWins = pennyWins;
    }

    /* Getter for variable pennyDraws.
     * @return int pennyDraws Number of times Penny played draw.
     */
    int getPennyDraws() {
        return pennyDraws;
    }

    /* Setter for variable pennyDraws.
     * @param int pennyDraws Number of times Penny played draw.
     */
    void setPennyDraws(int pennyDraws) {
        this.pennyDraws = pennyDraws;
    }

    /* Getter for variable sheldonLosses.
     * @return int sheldonLosses Number of losses of sheldon.
     */
    int getSheldonLosses() {
        return sheldonLosses;
    }

    /* Setter for variable sheldonLosses.
     * @param int sheldonLosses Number of times that Sheldon lost.
     */
    void setSheldonLosses(int sheldonLosses) {
        this.sheldonLosses = sheldonLosses;
    }

    /* Getter for variable sheldonWins.
     * @return int sheldonWins Number of wins of Sheldon.
     */
    int getSheldonWins() {
        return sheldonWins;
    }

    /* Setter for variable sheldonWins.
     * @param int sheldonWins Number of times that Sheldon won.
     */
    void setSheldonWins(int sheldonWins) {
        this.sheldonWins = sheldonWins;
    }

    /* Getter for variable sheldonDraws.
     * @return int sheldonDraws Number of times Sheldon played draw.
     */
    int getSheldonDraws() {
        return sheldonDraws;
    }

    /* Setter for variable sheldonDraws.
     * @param int sheldonDraws Number of times Sheldon played draw.
     */
    void setSheldonDraws(int sheldonDraws) {
        this.sheldonDraws = sheldonDraws;
    }

    /* Getter for variable rockWins.
     * @return int rockWins Number of wins for element rock.
     */
    int getRockWins() {
        return rockWins;
    }

    /* Setter for variable rockWins.
     * @param int rockWins Number of times rock won.
     */
    void setRockWins(int rockWins) {
        this.rockWins = rockWins;
    }

    /* Getter for variable rockLosses.
     * @return int rockLosses Number of losses for rock.
     */
    int getRockLosses() {
        return rockLosses;
    }

    /* Setter for variable rockLosses.
     * @param int rockLosses Number of times rock lost.
     */
    void setRockLosses(int rockLosses) {
        this.rockLosses = rockLosses;
    }

    /* Getter for variable rockDraws.
     * @return int rockDraws Number of draws for rock.
     */
    int getRockDraws() {
        return rockDraws;
    }

    /* Setter for variable rockDraws.
     * @param int rockDraws Number of times that rock played draw.
     */
    void setRockDraws(int rockDraws) {
        this.rockDraws = rockDraws;
    }

    /* Getter for variable paperWins.
     * @return int paperWins Number of wins for paper.
     */
    int getPaperWins() {
        return paperWins;
    }

    /* Setter for variable paperWins.
     * @param int paperWins Number of times paper won.
     */
    void setPaperWins(int paperWins) {
        this.paperWins = paperWins;
    }

    /* Getter for variable paperLosses.
     * @return int paperLosses Number of losses for paper.
     */
    int getPaperLosses() {
        return paperLosses;
    }

    /* Setter for variable paperLosses.
     * @param int paperLosses Number of times paper lost.
     */
    void setPaperLosses(int paperLosses) {
        this.paperLosses = paperLosses;
    }

    /* Getter for variable paperDraws.
     * @return int paperDraws Number of times paper played draw.
     */
    int getPaperDraws() {
        return paperDraws;
    }

    /* Setter for variable paperDraws.
     * @param int paperDraws Number of times paper played draw.
     */
    void setPaperDraws(int paperDraws) {
        this.paperDraws = paperDraws;
    }

    /* Getter for variable scissorsWins.
     * @return int scissorsWins Number of times scissors won.
     */
    int getScissorsWins() {
        return scissorsWins;
    }

    /* Setter for variable scissorsWins.
     * @param int scissorsWins Number of times scissors won.
     */
    void setScissorsWins(int scissorsWins) {
        this.scissorsWins = scissorsWins;
    }

    /* Getter for variable scissorsLosses.
     * @return int scissorsLosses Number of times scissors lost.
     */
    int getScissorsLosses() {
        return scissorsLosses;
    }

    /* Setter for variable scissorsLosses.
     * @param int scissorsLosses Number of times scissors lost.
     */
    void setScissorsLosses(int scissorsLosses) {
        this.scissorsLosses = scissorsLosses;
    }

    /* Getter for variable scissorsDraws.
     * @return int scissorsDraws Number of times scissors played draw.
     */
    int getScissorsDraws() {
        return scissorsDraws;
    }

    /* Setter for variable scissorsDraws.
     * @param int scissorsDraws Number of times scissors played draw.
     */
    void setScissorsDraws(int scissorsDraws) {
        this.scissorsDraws = scissorsDraws;
    }

    /* Getter for variable lizardWins.
     * @return int lizardWins Number of times lizard won.
     */
    int getLizardWins() {
        return lizardWins;
    }

    /* Setter for variable lizardWins.
     * @param int lizardWins Number of times lizard won.
     */
    void setLizardWins(int lizardWins) {
        this.lizardWins = lizardWins;
    }

    /* Getter for variable lizardLosses.
     * @return int lizardLosses Number of times lizard lost.
     */
    int getLizardLosses() {
        return lizardLosses;
    }

    /* Setter for variable lizardLosses.
     * @param int lizardLosses Number of times lizard lost.
     */
    void setLizardLosses(int lizardLosses) {
        this.lizardLosses = lizardLosses;
    }

    /* Getter for variable lizardDraws.
     * @return int lizardDraws Number of times lizard played draw.
     */
    int getLizardDraws() {
        return lizardDraws;
    }

    /* Setter for variable lizardDraws.
     * @param int lizardDraws Number of times lizard played draw.
     */
    void setLizardDraws(int lizardDraws) {
        this.lizardDraws = lizardDraws;
    }

    /* Getter for variable spockWins.
     * @return int spockWins Number of times Spock won.
     */
    int getSpockWins() {
        return spockWins;
    }

    /* Setter for variable spockWins.
     * @param int spockWins Number of times spock won.
     */
    void setSpockWins(int spockWins) {
        this.spockWins = spockWins;
    }

    /* Getter for variable spockLosses.
     * @return int spockLosses Number of times Spock lost.
     */
    int getSpockLosses() {
        return spockLosses;
    }

    /* Setter for variable spockLosses.
     * @param int spockLosses Number of times spock lost.
     */
    void setSpockLosses(int spockLosses) {
        this.spockLosses = spockLosses;
    }

    /* Getter for variable spockDraws.
     * @return int spockDraws Number of times Spock played draw.
     */
    int getSpockDraws() {
        return spockDraws;
    }

    /* Setter for variable spockDraws.
     * @param int spockDraws Number of times spock played draw.
     */
    void setSpockDraws(int spockDraws) {
        this.spockDraws = spockDraws;
    }
}
