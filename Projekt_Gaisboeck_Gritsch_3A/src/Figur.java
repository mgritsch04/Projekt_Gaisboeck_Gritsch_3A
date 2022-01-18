/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public abstract class Figur {

    Position position;

    public Figur(Position position) {
        this.position = position;
    }

    public abstract boolean[][] possibleMoves();

}
