#  Readability Score

# Stage #1: Simplest estimation

Description

Ever wonder, how to estimate if the text is hard or easy to read? This is pretty easy for a human - you just read the text and feel if you struggling or not. But how to teach the computer to do that? In this project, you will write such a program.

Firstly, let's create a simple one. If the text contains more than 100 symbols (including spacebars and punctuation) then the text is considered hard to read. Else, the text is considered easy to read. If the text contains exactly 100 symbols then it is still easy to read.

The input contains a single line with text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

Output examples

This text is simple to read!
EASY
This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence.
HARD
