package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

class MiniMax {
    static int start(BoardState node, int depth, Colour myPlayer, boolean isMax) {
        // If we've run out of lookahead or game is finished
        if (depth == 0 || node.getRedShapes().isEmpty() || node.getGreenShapes().isEmpty())
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());

        if (isMax) {
            Shape shape = (myPlayer.isGreen()) ? node.getGreenShapes().getFirst()
                    : node.getRedShapes().getFirst();

            if (myPlayer.isGreen()) node.removeGreenShape();
            else node.removeRedShape();

            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            int maxScore = -9999;

            for (Tile tile : possibleMoves) {
                BoardState child = new BoardState(node);
                child.addTile(tile);

                int tileScore = MiniMax.start(child, depth - 1, myPlayer, false);

                return Math.max(maxScore, tileScore);
            }

            return maxScore;

        } else {
            Shape shape = (myPlayer.isGreen()) ? node.getRedShapes().getFirst()
                    : node.getGreenShapes().getFirst();

            if (myPlayer.isGreen()) node.removeRedShape();
            else node.removeGreenShape();

            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            int minScore = 9999;

            for (Tile tile : possibleMoves) {
                BoardState child = new BoardState(node);
                child.addTile(tile);

                int tileScore = MiniMax.start(child, depth - 1, myPlayer, true);

                return Math.min(minScore, tileScore);
            }

            return minScore;
        }
    }
}
