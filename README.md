#  Readability Score

# Stage #4: More parameters

Description

In this stage, you should implement various other scientific approaches to calculate a readability score.

You can look at different ages corresponding to the different scores by the table in this article. This table is suitable for all the algorithms described in this stage. To calculate the age use upper bound of the range. For example, if the range is 12-13 year olds then it's upper bound is 13 year olds.

The first one is Flesch–Kincaid readability tests. To calculate this, you also need to create a method that calculates a number of syllables in a word. The formula is listed below. You can learn more here. You can use the second formula to calculate the index - it allows you to easily calculate the age of a person using the same table from the Automated Readability Index.

score = 0.39 ∗ (words / sentences) +11.8 ∗ (syllables / words) − 15.59

The second one is SMOG index. It stands for Simple Measure of Gobbledygook. To calculate this, you need to count the number of polysyllables which is the number of words with more than 2 syllables. The formula is shown below. You can find out more here. The Wikipedia page says that at least 30 sentences are required for this index to work properly. Don't pay attention to this, just keep it in mind when you use this index in real life. As in the previous example, the grade level is calculated here, so to get the age of a person you need to use the table from the first link.

score = 1.043 ∗ √(polysyllables ∗ (30 / sentences)) + 3.1291

The next one is Coleman–Liau index. The formula is shown below. You can find out more here. L is the average number of characters per 100 words and S is the average number of sentences per 100 words. Like all other indexes, the output is a person's grade level. Like all other indexes, the result is a minimum grade level of the person needed to understand this text.

score = 0.0588 ∗ L − 0.296 ∗ S − 15.8

So, in this stage, you should program all three approaches. Don't forget about the Automated readability index - it should also be here. Also, there should be an option to choose all methods at the same time.

To count the number of syllables you should use letters a, e, i, o, u, y as vowels. You can see here examples and difficulties with determining vowels in a word with 100% accuracy. So, let's use the following 4 rules:

1. Count the number of vowels in the word.
2. Do not count double-vowels (for example, "rain" has 2 vowels but is only 1 syllable)
3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" is 1 syllable) 
4. If at the end it turns out that the word contains 0 vowels, then consider this word as 1-syllable.

Output example
    
    java Main in.txt
    The text is:
    This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.
    
    Words: 137
    Sentences: 14
    Characters: 687
    Syllables: 210
    Polysyllables: 17
    Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all
    
    Automated Readability Index: 7.08 (about 13 year olds).
    Flesch–Kincaid readability tests: 6.31 (about 12 year olds).
    Simple Measure of Gobbledygook: 9.42 (about 15 year olds).
    Coleman–Liau index: 10.66 (about 17 year olds).
    
	This text should be understood in average by 14.25 year olds.

# Stage #3: Score!

Description

In this stage, you will program the Automated readability index. It was introduced in 1968 and a lot of research works rely on this.The index is calculated by the following formula:

	score = 4.71 x (characters / words) + 0.5 x (words / sentences) - 21.43

You can look at different ages corresponding to the different scores by the table in this article.

https://en.wikipedia.org/wiki/Automated_readability_index

Also, your program should read a file instead of typing a text manually. You should pass the filename through the command line arguments.

The program should output the score itself and an approximate age needed to comprehend the text.
Use rounding function to calculate the score as integer.

You should also print how many characters, words, and sentences the text has.

The number of characters is any visible symbol (so, in the real text it's everything except space, newline "\n" and tab "\t").

Notice, that the text can contain multiple lines, not just a single line like in the previous stages. You should analyze all the lines.

Output example

	java Main in.txt
	The text is:
	Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure

	Words: 108
	Sentences: 6
	Characters: 580
	The score is: 12.86
	This text should be understood by 18-24 year olds.
    java Main in.txt
    The text is:
    This is the page of the Simple English Wikipedia. A place where people work together to write encyclopedias in different languages. That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License 3 and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. You may ask questions at Simple talk.
    
    Words: 100
    Sentences: 10
    Characters: 476
    The score is: 5.98
    This text should be understood by 11-12 year olds. 

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
