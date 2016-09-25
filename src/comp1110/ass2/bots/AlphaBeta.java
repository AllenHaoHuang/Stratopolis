package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

class AlphaBeta {
    static int start(BoardState node, int depth, Colour myPlayer, boolean isMax, int alpha, int beta) {

        if (depth == 0 || node.isFinished())
            return (int)(node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer()));

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

            for (Tile tile : possibleMoves) {
                BoardState child = new BoardState(node);
                child.addTile(tile);

                int score = start(child, depth-1, myPlayer, false, alpha, beta);
                alpha = Math.max(score, alpha);
                if (alpha >= beta) {
                    break;  // beta cut-off
                }
            }
            return alpha;

        } else {Shape shape;

            if (myPlayer.isGreen()) {
                shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            } else {
                shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            }

            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);

            for (Tile tile : possibleMoves) {
                BoardState child = new BoardState(node);
                child.addTile(tile);

                int score = start(child, depth-1, myPlayer, true, alpha, beta);
                beta = Math.min(score, beta);
                if (alpha >= beta) {
                    break; // alpha cut-off
                }
            }
            return beta;
        }

    }


}


