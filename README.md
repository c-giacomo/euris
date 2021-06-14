# euris

Library for the calculation of the 4 fundamental operations (sum, multiplication, division, substraction) following the pre-1970 British monetary system.

You can import the .jar in another project and use the Operation interface method default implementation with Result Object. For Example:

    Operations<Result, Price, Integer> ops = new OperationsImpl();
    Result res = ops.sum(new Price(new Pound(5), new Shillings(5), new Pence(5)), new Price(new Pound(5), new Shillings(5), new Pence(5)));

Or build the .jar with maven (run the tests if you want) and launch it as an app with:

    java -jar [jarname].jar [params]
  
params sholud be a Price in the form Xp Ys Zd (or two) and an operation (+, -, *, /) for example:
  
    12p 5s 7d + 1p 4s 9d

Or

    12p 5s 7d * 3
  
Clearly + is sum, - is substraction, * is multiplication, / is division and p, s and d means Pound, Shillings and Pence
