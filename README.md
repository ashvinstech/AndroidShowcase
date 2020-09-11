
# AndroidShowcaseView
A cool looking Showcase for app feature's introduction in android with latest Android X code 


This library is heavily inspired by the original [ShowcaseView library][1].


![Logo](https://raw.githubusercontent.com/ashvinstech/AndroidShowcase/master/sample/src/main/res/drawable-xxhdpi/AndroidShowcase.jpeg)


![Logo](https://raw.githubusercontent.com/ashvinstech/AndroidShowcase/master/sample/src/main/res/drawable-xxhdpi/AndroidShowcase2.jpeg)

# Gradle
--------

[![jitpack][4]][5]

Add the jitpack repo to your your project's build.gradle at the end of repositories [Why?](#why-jitpack)

/build.gradle
```groovy
allprojects {
	repositories {
		jcenter()
		maven { url "https://jitpack.io" }
	}
}
```

Then add the dependency to your module's build.gradle:

/app/build.gradle
```groovy
implementation 'com.github.ashvinstech:AndroidShowcaseView:1.0'
```

NOTE: Some people have mentioned that they needed to add the @aar suffix to get it to resolve from JitPack:
```groovy
implementation 'com.github.ashvinstech:AndroidShowcaseView:1.0@aar'
```

# How to use
--------
This is the basic usage of a single showcase view, you should check out the sample app for more advanced usage.

```java

	// single example
	new AndrioidShowcaseView.Builder(this)
		.setTarget(mButtonShow)
		.setDismissText("GOT IT")
		.setContentText("This is some amazing feature you should know about")
		.setDelay(withDelay) // optional but starting animations immediately in onCreate can make them choppy
		.singleUse(SHOWCASE_ID) // provide a unique ID used to ensure it is only shown once
		.show();
                
                
                
                
	// sequence example            
	ShowcaseConfig config = new ShowcaseConfig();
	config.setDelay(500); // half second between each showcase view

	AndroidShowcaseSequence sequence = new AndroidShowcaseSequence(this, SHOWCASE_ID);

	sequence.setConfig(config);

	sequence.addSequenceItem(mButtonOne,
		"This is button one", "GOT IT");

	sequence.addSequenceItem(mButtonTwo,
		"This is button two", "GOT IT");

	sequence.addSequenceItem(mButtonThree,
		"This is button three", "GOT IT");

	sequence.start();
                
```

# Why Jitpack
------------
Publishing libraries to Maven is a chore that takes time and effort. Jitpack.io allows me to release without ever leaving GitHub so I can release easily and more often.


# License
-------

    Copyright 2015 Dean Wild

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.





[1]: https://github.com/amlcurran/ShowcaseView
[2]: http://i.imgur.com/rFHENgz.gif
[3]: https://code.google.com/p/android-flowtextview/
[4]: https://img.shields.io/github/release/deano2390/MaterialShowcaseView.svg?label=JitPack
[5]: https://jitpack.io/#deano2390/MaterialShowcaseView
