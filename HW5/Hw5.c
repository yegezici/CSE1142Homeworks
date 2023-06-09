
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct song
{
    char songName[25];
    int duration;
    struct song *nextPtr;
};

typedef struct song Song;
typedef Song *SongPtr;

void insert(SongPtr *sPtr, char name[25], int d);
int delete(SongPtr *sPtr, char name[25]);
int isEmpty(SongPtr sPtr);
void printList(SongPtr currentPtr);
void instructions();
void printList(SongPtr currentPtr);

int main()
{
    FILE *file = fopen("songs.txt", "r");
    char line[35];
    SongPtr startPtr = NULL;

    if (file == NULL)
    {
        printf("Failed to open the file.\n");
        return 1;
    }

    while (fgets(line, sizeof(line), file) != NULL)
    {
        int i;
        char name[25];
        int min, sec, dur;

        for (i = 0; i < 35; i++)
        {
            if (line[i + 3] == ':')
                break;
            name[i] = line[i];
        }
        name[i] = '\0';
        for (i; line[i] != '\0'; i++)
        {
            if (line[i] == ':')
            {
                min = line[i - 1] - 48 + (line[i - 2] - 48) * 10;
                sec = (line[i + 1] - 48) * 10 + line[i + 2] - 48;
                dur = min * 60 + sec;
                insert(&startPtr, name, dur);
                break;
            }
        }
    }
    printList(startPtr);
    instructions();
    printf("\n? ");
    int choice;
    scanf("%d", &choice);
    while (choice != 5)
    {
        if (choice == 1)
        {
            printf("Enter a song name with duration:\n");
            char ins[35];
            scanf(" %[^\n]", ins);
            int i;
            char name[25];
            int min, sec, dur;

            for (i = 0; i < 35; i++)
            {
                if (ins[i + 3] == ':')
                    break;
                name[i] = ins[i];
            }
            name[i] = '\0';
            for (i; ins[i] != '\0'; i++)
            {
                if (ins[i] == ':')
                {
                    min = ins[i - 1] - 48;
                    sec = (ins[i + 1] - 48) * 10 + ins[i + 2] - 48;
                    dur = min * 60 + sec;
                    insert(&startPtr, name, dur);
                    break;
                }
            }
        }
        else if (choice == 2)
        {
            char del[25];
            printf("Enter a song name: \n");
            scanf(" %[^\n]", del);
            if (delete (&startPtr, del))
            {
                printf("The song \"%s\" is deleted from the list!", del);
            }
            else
            {
                printf("%s not found.\n", del);
            }
        }
        else if (choice == 3)
        {
            printList(startPtr);
        }
        else if (choice == 4)
        {
            printf("Enter a file name:\n");
            char filename[25];
            scanf("%s", filename);
            FILE *output = fopen(filename, "w");

            Song *ptr;
            ptr = startPtr;

            fprintf(output, "The list in duration-time order:\n");
            int i = 1;
            while (ptr != NULL)
            {
                fprintf(output, "\t\t%d.%s  %d:%d\n", i, ptr->songName, ptr->duration / 60, ptr->duration % 60);
                ptr = ptr->nextPtr;
                i++;
            }
            fclose(output);
            printf("Output is printed to the file %s\n", filename);
        }

        instructions();
        printf("\n%s ", "?");
        scanf("%d", &choice);
    }
    fclose(file);
}

void instructions()
{
    printf("\nEnter your choice: \n\t1 to insert a song into the list.\n\t2 to delete a song from the list.\n\t3 to print the songs in the list.\n\t4 to print the songs to an output file.\n\t5 to end");
}
void insert(SongPtr *sPtr, char name[25], int d)
{
    SongPtr newPtr = malloc(sizeof(Song)); // create node
    if (newPtr != NULL)
    {
        strcpy(newPtr->songName, name);
        newPtr->duration = d;
        newPtr->nextPtr = NULL;
        SongPtr previousPtr = NULL;
        SongPtr currentPtr = *sPtr;

        while (currentPtr != NULL && d > currentPtr->duration)
        {
            previousPtr = currentPtr;
            currentPtr = currentPtr->nextPtr;
        }
        if (previousPtr == NULL)
        {
            newPtr->nextPtr = *sPtr;
            *sPtr = newPtr;
        }
        else
        {
            previousPtr->nextPtr = newPtr;
            newPtr->nextPtr = currentPtr;
        }
    }
    else
    {
        printf("It is not inserted. No memory available.\n");
    }
}
int isEmpty(SongPtr sPtr)
{
    return sPtr == NULL;
}
void printList(SongPtr currentPtr)
{
    if (isEmpty(currentPtr))
    {
        puts("List is empty.\n");
    }
    else
    {
        puts("The list in duration-time order:");
        int i = 1;
        while (currentPtr != NULL)
        {
            printf("\t\t%d.%s  %d:%d\n", i, currentPtr->songName, currentPtr->duration / 60, currentPtr->duration % 60);
            currentPtr = currentPtr->nextPtr;
            i++;
        }
    }
}
int delete(SongPtr *sPtr, char name[25])
{
    int result = strcmp((*sPtr)->songName, name);
    if (result == 0)
    {
        SongPtr tempPtr = *sPtr;
        *sPtr = (*sPtr)->nextPtr;
        free(tempPtr);
        return 1;
    }
    else
    {
        SongPtr previousPtr = *sPtr;
        SongPtr currentPtr = (*sPtr)->nextPtr;
        int r1 = strcmp(currentPtr->songName, name);
        while (currentPtr != NULL && r1 != 0)
        {
            previousPtr = currentPtr;
            currentPtr = currentPtr->nextPtr;
            r1 = strcmp(currentPtr->songName, name);
        }
        if (currentPtr != NULL)
        {
            SongPtr tempPtr = currentPtr;
            previousPtr->nextPtr = currentPtr->nextPtr;
            char *returnS;
            free(tempPtr);
            return 1;
        }
    }
    return 0;
}
