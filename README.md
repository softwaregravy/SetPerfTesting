SetPerfTesting
==============

This is a simple little package to compare the runtime of verious ways to checking for String containment in a set which is initially available as an Array. 

The question we seek to answer is: "should we create a set so we can do a very cheap `contains` call? or should we just iterate through the array?

Below are my results running in eclipse on my local machine (OS X, Java 6):

Phase 1:
========

```bash
Control: runtime was 0.018958
ArrayIteration: runtime was 1.33975
GuavaNewHashSet: runtime was 20.755466
HashSetContains: runtime was 21.903718
HashSetContains2: runtime was 30.473316
HashSetContains3: runtime was 21.58528
HashSetAddAll: runtime was 31.327672
HashSetAddAll2: runtime was 22.110961
```

I expected the array iteration to be the fastest, but didn't expect it to be quite that significant. These results are repeatable. Some interesting observations:

Arrays#astList is almost free (compare HashSetContains and HashSetContains3).

Resizing big hashsets can be very expensive (compare HashSetContains and HashSetContains2 and also HashSetAddAll and HashSetAddAll2).

For my use case -- finding strings in an array -- unless you are sure you will do more than 15 lookups, you're better off just iterating through the array.

Phase 2: 
========
Having observed phase 1, I decided to add ArrayBinarySearch and ListContains. For my purposes, sorting the array ahead of time would not be hard for me, so the ArrayBinarySearch is very promising.

```bash
Control: runtime was 0.019205
ArrayIteration: runtime was 1.573599
GuavaNewHashSet: runtime was 21.952205
HashSetContains: runtime was 23.380877
HashSetContains2: runtime was 31.814267
HashSetContains3: runtime was 22.062307
HashSetAddAll: runtime was 34.464576
HashSetAddAll2: runtime was 23.336411
ArrayBinarySearch: runtime was 0.025991
ListContains: runtime was 1.837742
```

I was not disappointed. The binary search is incredibly fast. The ListContains is almost as cheap as a straight iteration, which is expected.


