


Skip to content
Using Northeastern University Mail with screen readers

Conversations
Using 0.64 GB
Program Policies
Powered by Google
Last account activity: 0 minutes ago
Details

Fixes:
Model:
-The Model now has ReadOnlyModel and AnimationModel interfaces
- ReadOnlyAnimationModel have getters
- AnimationModel have getters and setters.
- added Tweening class as a function object to get the transformations inbetween motion.



View:
- Now has EnhancedVisualView for a more advanced Visual view with user interfaces, with the following functionality:
	- Start, pause, resume, and restart (i.e. rewind to beginning and start the animation again) the animation with explicit user input (e.g. key press, button click, etc).
	- Enable/disable looping: enabling looping should cause the animation to automatically restart once it reaches the end.
	- Increase or decrease the speed of the animation, as it is being played, and immediately see the results.
	- Create or delete shapes
	- Create, delete, or modify keyframes of existing shapes
- Visual View now works as expected
- Visual View now doesn't have jittery images
- SVG file fix of color change
- Panels are divided to 3 parts, the video playback controls, keyfame editor, and the visual animation panel.


Controller:
- Created an EnhancedController with more functionalities than normal Controller
- EnhancedController responds to button pressed
Readme Ass7.txt
Displaying Readme Ass7.txt.