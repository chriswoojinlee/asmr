# White Noise Player

## Perfect for studying, sleeping, and blocking out unwanted noise!

An overview of this project:
- The application will produce various white noises. This may include but is 
  not limited to therapeutic sounds such as rain, wind, thunder, crackling 
  fire, singing bowls, and tuning forks. Core features include being able to set a 
  timer at which upon fully counting down, the sounds will pause (intended for
  when trying to fall asleep), being able to make custom preset sound profiles, 
  being able to combine multiple sounds at once, and being able to adjust the volume
  of each sound.
- This application is aimed towards students in higher education like myself 
  since maximizing productivity and minimizing distractions is a crucial aspect
  of our lives, but in hindsight, *anyone* of any age can utilize this app 
  equally well for the general purposes of blocking out noise, perhaps for 
  when sleeping or meditating.
- This project is of interest to me because when I study and sleep every day,
  I occasionally encounter distracting noise from the rest of my household 
  (after all, I have been around them much more frequently ever since the 
  COVID-19 outbreak). To remedy this, I feel like developing an application that 
  generates various white noises will allow me to become much more productive
  throughout the day and fall asleep quicker by blocking out unwanted noise.
  

## User Stories
- As a user, I want to be able to create a new sound profile.
- As a user, I want to be able to delete an existing sound profile.
- As a user, I want to be able to rename an existing sound profile.
- As a user, I want to be able to add a sound to an existing sound profile.
- As a user, I want to be able to delete a sound from an existing sound profile.
- As a user, I want to be able to play sounds in profiles.
- As a user, I want to be able to save profiles to file.
- As a user, I want to be able to load in saved profiles from file.
- As a user, I want to be able to be able to view the profiles I have made.
- As a user, I want to be able to be able to view the sounds in a profile.
- As a user, I want to be able to hear a trashcan sound when I delete a profile.

## Phase 4: Task 2
- Tested and designed a class in my model package that is robust 
  (ProfileManager.addProfile() and ProfileManager.deleteProfile())

## Phase 4: Task 3
- If I had more time to work on this project, I would refactor the hierarchy of my main 
  three model package classes, ProfileManager, Profile, and Sound. If my ProfileManager class 
  used a Map with objects of type Profile as keys and objects of type ArrayList<Sound> as 
  values, or if my ProfileManager and Profile classes extended a common interface that specifies
  add() and remove() methods, there would be a lot less redundancy between the code of these three 
  classes.

## Future User Stories (for my own reference)
- As a user, I want to be able to increase the volume of a sound.
- As a user, I want to be able to decrease the volume of a sound.
- As a user, I want to be able to set a volume limit.
- As a user, I want to be able to mute the application.
- As a user, I want to be able to pause my sound profile.
- As a user, I want to be able to set a timer at which upon count down,
  the app stops playing sound.