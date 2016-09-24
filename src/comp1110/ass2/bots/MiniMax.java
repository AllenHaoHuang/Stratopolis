package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

class MiniMax {

    static int start(BoardState node, int depth, Colour myPlayer, boolean isMax) {
        if (depth == 0 || node.isFinished()) {
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());
        }

        if (isMax) {
            Shape shape;

            if (myPlayer.isGreen()) {
                shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            } else {
                shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            }

            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            int maxScore = -9999;

            for (Tile t : possibleMoves) {
                BoardState child = new BoardState(node);
                child.addTile(t);

                int tileScore = start(child, depth-1, myPlayer, false);
                if (tileScore > maxScore) {
                    maxScore = tileScore;
                }
            }
            return maxScore;
        } else {
            Shape shape;

            if (myPlayer.isGreen()) {
                shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            } else {
                shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            }

            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            int minScore = 9999;

            for (Tile t : possibleMoves) {
                BoardState child = new BoardState(node);
                child.addTile(t);

                int tileScore = start(child, depth-1, myPlayer, true);
                if (tileScore < minScore) {
                    minScore = tileScore;
                }
            }
            return minScore;
        }
    }
}
