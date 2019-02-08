package gameobject;

/**
 * The GoldFish is a Yellow Tail Flounder
 * 
 * @author W Mathieu Mimms-Boyce
 * @author Dylan Martin
 * @see Animal
 */
public class GoldFish extends Animal {
	
	/**
	 * This Constructor establishes the position, depth, and size of the fish.
	 * Its other parameters are unique values corresponding to the fish.
	 * 
	 * @see Animal#Animal(int, int, int, int, int)
	 */
	public GoldFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);

		setImagePath("images/GoldfishRight.png");
		setRealPic("images/yellowtailflounder.png");
		setName("Yellow Tail Flounder");
		setAvgSize(2);
		setWeight(25);
		setSpeed(5);
		setQuestion(new Question(
				"Yellowtail Flounders can use camouflage to change both skin color and pattern to match their environment.",
				"The Yellowtail Flounder can ...", "use camouflage to blend into its surroundings",
				"jump out of the water", "swim very fast", "squirt ink at predators"));
		setPathLength(xSize * 3);
	}

	/* (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 */
	@Override
	public void update() {
		int pathState = getPathState();
		int x = getxPos();
		int y = getyPos();
		int speed = getSpeed();
		int length = getPathLength();

		// our waypoints are located at each third of the way through our path.
		int wayPoint1 = length / 3;
		int wayPoint2 = wayPoint1 * 2;
		int wayPoint3 = length;

		if (!isMovingForward()) {
			// we multiply by -1 so that we will head the other way, this is
			// executed after we've reached the end of our path and must return.
			speed *= -1;
			wayPoint1 *= -1;
			wayPoint2 *= -1;
			wayPoint3 *= -1;
			this.setImagePath("images/GoldfishLeft.png");
			// we switch to a greater than sign because we are headed the
			// opposite direction
			if (pathState > wayPoint1) {
				setxPos(x + speed);
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			} else if (pathState > wayPoint2) {
				setyPos(y + speed);
			} else if (pathState > wayPoint3) {
				setxPos(x + (speed / 2));
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			}
		} else {
			setImagePath("images/GoldfishRight.png");
			if (pathState < wayPoint1) {
				// swim right until waypoint1
				setxPos(x + speed);
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			} else if (pathState < wayPoint2) {
				// swim down until waypoint2
				setyPos(y + speed);
			} else if (pathState < wayPoint3) {
				// swim to waypoint3
				setxPos(x + (speed / 2));
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			}
		}
		updatePosition();
		this.pathCount++;
		// System.out.println("Fish at x: " + super.getxPos() + " y: " +
		// super.getyPos()); Prints the position for debugging
	}
}