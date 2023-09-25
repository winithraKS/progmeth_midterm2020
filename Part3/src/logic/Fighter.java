package logic;

public class Fighter extends Piece{
    private boolean promoted;
    private PositionList promotedMovePositions;

    public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
        super(initialPositionX, initialPositionY, reverse, name);

        movePositions.add(-1,2);
        movePositions.add(1,2);

        promotedMovePositions = new PositionList();

        promotedMovePositions.add(0,2);
        promotedMovePositions.add(1,0);
        promotedMovePositions.add(0,-2);
        promotedMovePositions.add(-1,0);

        if(isReverse()) {
            for(int i = 0;i<promotedMovePositions.size();i++) {
                promotedMovePositions.get(i).reverse();
            }
            for(int i = 0;i<movePositions.size();i++) {
                movePositions.get(i).reverse();
            }
        }

        promoted = false;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public PositionList getPromotedMovePositions() {
        return promotedMovePositions;
    }

    @Override
    public void move(int movePattern) {
        if(promoted){
            Position targetPosition = this.currentPosition.addPositionValue(promotedMovePositions.get(movePattern));
            setCurrentPosition(targetPosition);
            this.currentPosition.normalizedPosition();
        }
        else{
            Position targetPosition = this.currentPosition.addPositionValue(movePositions.get(movePattern));
            setCurrentPosition(targetPosition);
            this.currentPosition.normalizedPosition();
        }
    }

    public Position attackTargetPosition(int actionPattern) {
        // TODO Auto-generated method stub
        if(promoted){
            Position targetPosition = this.currentPosition.addPositionValue(promotedMovePositions.get(actionPattern));
            move(actionPattern);
            return targetPosition;
        }
        else{
            Position targetPosition = this.currentPosition.addPositionValue(movePositions.get(actionPattern));
            move(actionPattern);
            return targetPosition;
        }
    }
}
