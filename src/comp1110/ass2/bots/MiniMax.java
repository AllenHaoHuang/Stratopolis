package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.ArrayList;
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

    static int mimiMaxAlphaBeta(BoardState node, int depth, Colour myPlayer, boolean isMax, int alpha, int beta, LinkedList<Tile> moveList) {
        if (depth == 0 || node.isFinished()) {
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());
        }

        if (moveList.isEmpty()) {
            if (node.getPlayerTurn() == myPlayer) {
                return alpha;
            } else {
                return beta;
            }
        }

        if (isMax) {
            // Shape shape;
            if (myPlayer.isGreen()) {
            //    shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            } else {
            //    shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            }

            Tile head = moveList.getFirst();
            LinkedList<Tile> restOfList = moveList;
            restOfList.removeFirst();
            BoardState child = node;
            child.addTile(head);

            Shape nextShape;
            if (myPlayer.isGreen()) {
                nextShape = node.getRedShapes().getFirst();
            } else {
                nextShape = node.getGreenShapes().getFirst();
            }

            int newValue = mimiMaxAlphaBeta(child, depth - 1, myPlayer, false, alpha, beta, child.generatePossibleMoves(nextShape));

            if (newValue >= beta) {
                return beta;
            } else if (newValue > alpha) {
                return mimiMaxAlphaBeta(node, depth - 1, myPlayer, true, newValue, beta, restOfList);
            } else {
                return mimiMaxAlphaBeta(node, depth - 1, myPlayer, true, alpha, beta, restOfList);
            }
        } else {
            // Shape shape;
            if (myPlayer.isGreen()) {
            //    shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            } else {
            //    shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            }

            Tile head = moveList.getFirst();
            LinkedList<Tile> restOfList = moveList;
            restOfList.removeFirst();
            BoardState child = node;
            child.addTile(head);

            Shape nextShape;
            if (myPlayer.isGreen()) {
                nextShape = node.getGreenShapes().getFirst();
            } else {
                nextShape = node.getRedShapes().getFirst();
            }

            int newValue = mimiMaxAlphaBeta(child, depth - 1, myPlayer, false, alpha, beta, child.generatePossibleMoves(nextShape));

            if (newValue <= alpha) {
                return alpha;
            } else if (newValue < beta) {
                return mimiMaxAlphaBeta(node, depth - 1, myPlayer, true, alpha, newValue, restOfList);
            } else {
                return mimiMaxAlphaBeta(node, depth - 1, myPlayer, true, alpha, beta, restOfList);
            }
        }
    }
}
