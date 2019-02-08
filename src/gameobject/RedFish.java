package gameobject;

/**
 * The RedFish is a Red Drum
 * 
 * @author Dylan Martin
 * @see Animal
 */
public class RedFish extends Animal {

	/**
	 * This Constructor establishes the position, depth, and size of the fish.
	 * Its other parameters are unique values corresponding to the fish.
	 * 
	 * @see Animal#Animal(int, int, int, int, int)
	 */
	public RedFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/RedFishLeft.png");
		this.setRealPic("images/reddrum.png");
		this.setName("Red Drum");
		this.setWeight(20);
		this.setAvgSize(2);
		this.setSpeed(12);
		this.setQuestion(new Question("Big Red Drum are referred to as Red Bulls.", "What are large Red Drum called?",
				"Red Bulls", "Red Fish", "Big Fish", "Puppy Drum"));
		this.setPathLength(xSize * 22);
	}

	/* (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 */
	@Override
	public void update() {
		// Creates a diamond pattern for the red fish and updates its position and
		// sprite
		this.setPathState(this.getPathLength() / this.getSpeed());
		if (this.pathCount % this.getPathState() < this.getPathState() / 4) {
			this.setImagePath("images/RedFishLeft.png");
			this.setyPos(this.getyPos() - this.getSpeed() / 2);
			this.setxPos(this.getxPos() - this.getSpeed());
		} else if (this.pathCount % this.getPathState() < this.getPathState() / 2) {
			this.setImagePath("images/RedFishLeft.png");
			this.setyPos(this.getyPos() + this.getSpeed() / 2);
			this.setxPos(this.getxPos() - this.getSpeed());
		} else if (this.pathCount % this.getPathState() < 3 * this.getPathState() / 4) {
			this.setImagePath("images/RedFishRight.png");
			this.setyPos(this.getyPos() + this.getSpeed() / 2);
			this.setxPos(this.getxPos() + this.getSpeed());
		} else {
			this.setImagePath("images/RedFishRight.png");
			this.setyPos(this.getyPos() - this.getSpeed() / 2);
			this.setxPos(this.getxPos() + this.getSpeed());
		}
		this.pathCount++;
	}

}
