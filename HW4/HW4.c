
#include <stdio.h>

typedef struct
{
    char string[50];
} String;

int charAt(String *s, int index)
{
    int lenghtOfS;
    for (lenghtOfS = 0; s->string[lenghtOfS] != '\0'; lenghtOfS++)
        ;
    if (index >= lenghtOfS || index < 0)
    {
        return -1;
    }
    else
    {
        char r = s->string[index];
        return r;
    }
}

String *concat(String *s1, String *s2)
{
    int lenghtOfS1;
    for (lenghtOfS1 = 0; s1->string[lenghtOfS1] != '\0'; lenghtOfS1++)
        ;
    int lenghtOfS2;
    for (lenghtOfS2 = 0; s2->string[lenghtOfS2] != '\0'; lenghtOfS2++)
        ;
    String concated;
    String *returnV;
    int i, k;
    for (i = 0; i < lenghtOfS1; i++)
        concated.string[i] = s1->string[i];
    concated.string[lenghtOfS1] = ' ';
    for (k = lenghtOfS1 + 1; k < lenghtOfS1 + lenghtOfS2; k++)
        concated.string[k] = s2->string[k - lenghtOfS1 - 1];

    concated.string[k] = '\0';
    returnV = &concated;
    return returnV;
}
unsigned int strSearch(String *s1, String *s2)
{
    int lenghtOfS1;
    for (lenghtOfS1 = 0; s1->string[lenghtOfS1] != '\0'; lenghtOfS1++)
        ;
    int lenghtOfS2;
    for (lenghtOfS2 = 0; s2->string[lenghtOfS2] != '\0'; lenghtOfS2++)
        ;
    lenghtOfS1--;
    lenghtOfS2--;
    int length, i, y, boolean = 0, startPoint = 0;
    for (i = 0; i < lenghtOfS1; i++)
    {
        length = 0;
        if (s1->string[i] == ' ')
            startPoint = i;
        for (y = 0; y < lenghtOfS2; y++)
        {
            if (s1->string[i + y] == s2->string[y])
            {
                length++;
                if (length == lenghtOfS2)
                    boolean = 1;
            }
        }
        if (boolean)
            break;
    }
    int endPoint = startPoint;
    for (endPoint = startPoint + 1; s1->string[endPoint] != ' ' && s1->string[endPoint] != '\0'; endPoint++)
        ;
    endPoint--;
    if (length == lenghtOfS2)
        return endPoint - startPoint;
    else
        return 0;
}
unsigned int findScore(String *s1)
{
    int lenghtOfS1;
    for (lenghtOfS1 = 0; s1->string[lenghtOfS1] != '\0'; lenghtOfS1++)
        ;
    int total = 0;
    int i;
    for (i = 0; i < lenghtOfS1; i++)
    {
        if (s1->string[i] == 'A' || s1->string[i] == 'a' || s1->string[i] == 'E' || s1->string[i] == 'e' ||
            s1->string[i] == 'I' || s1->string[i] == 'i' || s1->string[i] == 'O' || s1->string[i] == 'o' ||
            s1->string[i] == 'U' || s1->string[i] == 'u' || s1->string[i] == 'L' || s1->string[i] == 'l' ||
            s1->string[i] == 'N' || s1->string[i] == 'n' || s1->string[i] == 'R' || s1->string[i] == 'r' ||
            s1->string[i] == 'S' || s1->string[i] == 's' || s1->string[i] == 'T' || s1->string[i] == 't')
            total++;
        if (s1->string[i] == 'D' || s1->string[i] == 'd' || s1->string[i] == 'G' || s1->string[i] == 'g')
            total += 2;
        if (s1->string[i] == 'B' || s1->string[i] == 'b' || s1->string[i] == 'C' || s1->string[i] == 'c' || s1->string[i] == 'M' || s1->string[i] == 'm' || s1->string[i] == 'P' || s1->string[i] == 'p')
            total += 3;
        if (s1->string[i] == 'F' || s1->string[i] == 'f' || s1->string[i] == 'H' || s1->string[i] == 'h' || s1->string[i] == 'V' || s1->string[i] == 'v' || s1->string[i] == 'W' || s1->string[i] == 'w' || s1->string[i] == 'Y' || s1->string[i] == 'y')
            total += 4;
        if (s1->string[i] == 'K' || s1->string[i] == 'k')
            total += 5;
        if (s1->string[i] == 'J' || s1->string[i] == 'j' || s1->string[i] == 'X' || s1->string[i] == 'x')
            total += 8;
        if (s1->string[i] == 'Q' || s1->string[i] == 'q' || s1->string[i] == 'Z' || s1->string[i] == 'z')
            total += 10;
    }
    return total;
}
int main()
{
    FILE *input;
    char line[120];
    char nameOfFile[50];
    printf("Enter the name of the file: ");
    scanf("%s", nameOfFile);

    input = fopen(nameOfFile, "r");
    if (input == NULL)
    {
        printf("There is no file named %s.\nProgram ends.\n", nameOfFile);
        return 1;
    }
    FILE *output = fopen("output.txt", "w");
    printf("output.txt file has been created");
    int wordCount = 0, letterCount = 0;
    while (fgets(line, sizeof(line), input) != NULL)
    {
        int i = 0;
        String s;
        while (line[i] != ':')
        {
            if ((line[i] >= 'a' && line[i] <= 'z') || (line[i] >= 'A' && line[i] <= 'Z'))
                letterCount++;
            if (line[i] == ' ' && ((line[i + 1] >= 'a' && line[i + 1] <= 'z') || (line[i + 1] >= 'A' && line[i + 1] <= 'Z')))
                wordCount++;
            s.string[i] = line[i];
            i++;
            if (i == 4)
            {
                if (line[0] == 's' && line[1] == 't' && line[2] == 'a' && line[3] == 't')
                    break;
                if (line[0] == 'e' && line[1] == 'x' && line[2] == 'i' && line[3] == 't')
                    break;
            }
        }
        s.string[i] = '\0';
        if (line[0] == 's' && line[1] == 't' && line[2] == 'a' && line[3] == 't')
        {
            fprintf(output, "%s%d\n%s%d\n", "The number of words: ", wordCount, "The number of alphabetic letters: ", letterCount - 4);
        }
        if (line[0] == 'e' && line[1] == 'x' && line[2] == 'i' && line[3] == 't')
        {
            fprintf(output, "%s", "Program ends. Bye");
            return -1;
        }
        wordCount++;
        int num1 = 0;
        if (i != 4)
        {
            if (line[i] == ':')
                i++;
            num1 = line[i] - '0';
            i++;
        }
        if (num1 == 1)
        {
            if (line[i] == ',')
                i++;
            int num2 = line[i] - '0';
            fprintf(output, "%c\n", charAt(&s, num2));
        }
        else if (num1 == 2)
        {
            String s2;
            int k = 0;
            if (line[i] == ',')
            {
                while (line[i] != '\0')
                {
                    if ((line[i] >= 'a' && line[i] <= 'z') || (line[i] >= 'A' && line[i] <= 'Z'))
                        letterCount++;
                    if (line[i] == ' ' && ((line[i + 1] >= 'a' && line[i + 1] <= 'z') || (line[i + 1] >= 'A' && line[i + 1] <= 'Z')))
                        wordCount++;
                    i++;
                    s2.string[k] = line[i];
                    k++;
                }
                wordCount++;
            }
            String *p;
            int y;
            p = concat(&s, &s2);
            String z;
            for (y = 0; p->string[y] != '\0'; y++)
                z.string[y] = p->string[y];
            z.string[y] = '\0';
            fprintf(output, "%s\n", z.string);
        }
        else if (num1 == 3)
        {
            String s2;
            int k = 0;
            if (line[i] == ',')
            {
                while (line[i] != '\0')
                {
                    if ((line[i] >= 'a' && line[i] <= 'z') || (line[i] >= 'A' && line[i] <= 'Z'))
                        letterCount++;
                    if (line[i] == ' ' && ((line[i + 1] >= 'a' && line[i + 1] <= 'z') || (line[i + 1] >= 'A' && line[i + 1] <= 'Z')))
                        wordCount++;
                    i++;
                    s2.string[k] = line[i];
                    k++;
                }
                wordCount++;
            }
            fprintf(output, "%d\n", strSearch(&s, &s2));
        }
        else if (num1 == 4)
        {
            int y;
            fprintf(output, "%d\n", findScore(&s));
        }
    }
    fclose(input);
    fclose(output);
    return 0;
}
