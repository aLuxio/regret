(((This tutorial is almost done, be patient, young one)))

# LocalDateTime
So you've come across a calendar problem in a packet and you immediately skip it because trying to do operations and calculations on calendars is scary. I have to parse a calendar and tell you what day of the week it is? Yeet, see ya later. That's hard as heck my guy.

Or is it? What if I told you that there was a collection of classes that do all of the heavy lifting and dirty work for you?

Well my friends, the Java gods have smiled upon you once again. Introducing LocalDate, LocalTime, and LocalDateTime. Unfortunately, no, you can't just use LocalDateTime for everything. I mean, you *can,* but let's not even go there.

### So, what is LocalDate, LocalTime, and LocalDateTime? What does it do?

Okay, typing all three classes is incredibly tedious, so when I refer to all three, I'm just gonna say "LocalDateTime" unless I specify otherwise. Or you can just infer when I'm using it instead. Yeah, let's do that. You're smart, you can do it.

LocalDateTime is imported from the `java.time` package. Basically, when you create a LocalDateTime object and give it a value, Java treats that object like an actual calendar and/or time value.

> What?

Okay, so say you have a LocalTime object set to midnight (12:00 AM), and you wanted to add 13 hours and 30 minutes to it. The end result would be 1:30 PM. Like I said, it does all the dirty work for you. This is cool and all, but we can go deeper.
Say we have a LocalDateTime object set to January 1, 2000 at midnight (happy new year), and we add 25 hours to it. The end result will be 1:00 AM on January 2, 2000.

Cool, so now that you get the gist of it, let's get into how to use it in Java.

### How to use LocalDateTime

LocalDateTime objects aren't instantiated like most are. Like if you wanted to instantiate a scanner, you'd do `Scanner file = new Scanner()`. LocalDateTime doesn't have constructors, so we have to use the "set" methods built in to the classes. I put "set" in quotes because they're not called "set", but they essentially do the same thing, except they set all of the variables at the same time instead of one at a time like the set methods you guys are used to. These include, but are not limited to: `.of()`, `.parse()` (we'll get into that one later), and `.now()`.

##### LocalDate

Let's make a LocalDate object for January 1, 2000. Notice we're using LocalDate, so we don't even mess with time at all.

The `LocalDate.of()` method takes in parameters in **year, month, day** order, so the instantiation would look like

`LocalDate date = LocalDate.of(2000, 1, 1);`.

That wasn't bad, wasn't it? Now let's move on to LocalTime. 

##### LocalTime

It works pretty much the same way, use `LocalTime.of()` and fill in the respective parameters. LocalTime has three different `.of()` methods for different situations, but for this case, we're just gonna use the first that takes in **hour, minute**.

So if we wanted to make a LocalTime object for midnight, we would do 

`LocalTime time = LocalTime.of(0, 0);`.

> Whoa, whoa, what? Why 0 for the hour?

That's because LocalTime uses the 24 hour clock unless otherwise specified. If you were to put in 12 for the hour, you would be inputting noon instead of midnight. This won't be too much of a problem since you'll usually be taking in a date and time from a timestamp in a file, which we'll cover later.

##### LocalDateTime

So now we have `date` set to 1/1/2000 and `time` set to midnight, but what if we needed to do that operation that I mentioned earlier, the one where we added 25 hours to the date? You *could* do the operations seperately, but why do that when you can c o n d e n s e?

Enter LocalDateTime (the class this time, not the whole lot of them). The LocalDateTime class has *seven* damn `.of()` methods for pretty much every situation. Let's make a LocalDateTime object for the past two things that we made that I'm not gonna type out again. The `LocalDateTime.of()` method we're gonna use takes in data in **year, month, day, hour, minute** order. So...

`LocalDateTime happyFreakinNewYear = LocalDateTime.of(2000, 1, 1, 0, 0);`

> Okay, that's all fine and dandy, but what if you already have a LocalDate object and a LocalTime object? Would you do some bullshit like `.of(date.getYear(), date.getMonth() ...` -

*Hell* no. I mean, you could, but the Java gods made things easy for you. LocalDateTime has an `.of()` method that takes in a LocalDate object and a LocalTime object and combines them into one glorious LocalDateTime object. Feelsgoodman. Let's do that real quick.

```
// These two were the ones we made earlier
LocalDate date = LocalDate.of(2000, 1, 1);
LocalTime time = LocalTime.of(0, 0);

LocalDateTime newYear = LocalDateTime.of(date, time);
```

Nice! The LocalDateTime classes have plus and minus methods for years, months, days, etc. So without further ado, let's add 25 hours to `newYear`.

```
// These two were the ones we made earlier
LocalDate date = LocalDate.of(2000, 1, 1);
LocalTime time = LocalTime.of(0, 0);

LocalDateTime newYear = LocalDateTime.of(date, time);
System.out.println(newYear);
newYear = newYear.plus
System.out.println(newYear);
```

**Note:** LocalDateTime classes are *immutable* like strings, meaning you have to set the old object to the new one.

```
Output:
2000-01-01T00:00
2000-01-02T01:00
```

Yeah, the toString for LocalDateTime is a bit unconventional, but we're getting to the solution for that here in a bit. Other than that, you should be able to do those pesky calendar problems now!

### DateTimeFormatter

So you know how to use LocalDateTime, but since you're gonna be reading from files, the writers won't always be nice. Sometimes they'll give you the year, month, and day nice and seperated, but sometimes they'll give you a full-blown timestamp. You know, something like `08-04-1999 7:45 PM` (that's my birthday btw. I don't remember the time I was born, just go with it lol).

> You expect me to write a parser for that garbage?

If Josef didn't expose me to this nifty class I would. In fact, I learned about this because I actually *did* write a parser for that garbage. It made my code much longer than it should've been. Like, way longer.
