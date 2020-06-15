#  Readability Score

# Stage #2: Words and sentences

Description

But the real text can be pretty long and still can be easy to read isn't it? There need to be done another approach. How about calculating a number of words in each sentence? Clearly, if each sentence of the text contains a lot of words then this text is hard to read.

Let's suppose that if the text contains on average more than 10 words per sentence, then this text is hard to read. Otherwise, this text is easy to read. Don't worry, we will consider more scientific ways in the next stages.

The input contains a single line with text. Output "HARD" if the text is hard to read and "EASY" if the text is easy to read.

For example, the first example contains two sentences with 6 and 10 words (numbers also counts as words) so the average is 8 and this is less than 10. In the second example, there is also 2 sentences but with 6 and 16 words so the average is 11 and this is greater than 10. If the average is equal to 10 then the text is still considered easy to read.

Don't forget that the sentences can end with a dot as well as with an exclamation mark and a question mark. But the last sentence can be with or without a punctuation character at the end.

	Output examples

	This text is simple to read! It has on average less than 10 words per sentence.
	EASY
	This text is hard to read. It contains a lot of sentenses as well as a lot of words in each sentence
	HARD
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
