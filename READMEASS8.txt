Basically, we made adapters for each classes and interfaces to make the animation run. We made the adapter for Texture that is used to save motion. We made Dimension2DToSize and Position2DToPosition for the same purpose. 
We made the AnimationModelToProvider that adapts our AnimationModel to their Animation interface. Features contain addMotion that adds motion to the model, totalDuration that counts the number of whole tick of the animation. 
When we try to get all the shapes of the animation, we use the shape adapter because provider has their own shape class. and ours are using the string to make the shape. So we use shape adapter to 
convert String to Shape class. We leave unused method to return null. We made the adapters for Keyframe and Motion. They both are part of our transformation that keeps all the data that is needed to run the animation so it was easy to implement. 

The problem is that for the extra credit on assignment 7, implementing loading file and saving file, we commented them out and not leave them as it is because
it is giving us error as we run the program. We are heard from the tutor to comment them out because we do not have to make adpaters for them. We wish this does not take off points for touching provider's code.

We are able to get all of the features that is necessary for editor and visual view from provider to work with our code. Only the extra credit feature, which is load file and save file that we do not adapt.