# SOLUTION

- 
    - 4 endpoints were created:
        - GET `/interview/sentence/:id/word-count`
            - path parameter `id` is sentence id
            - returns word count for given sentence id
        - GET `/interview/sentence/all`
            - returns list of all sentences grouped by book id
            - endpoind does not have any input parameters
            - example response
          ```
              [
                {
                  "bookId": "c9eb2c3f-40d2-48cd-a0a9-4e58b634e010",
                  "sentences": [
                    {
                      "id": "77ae4c23-910f-48a6-a636-608b7a6b4478",
                      "value": "This is the first sentence bla bla.",
                      "wordCount": 7
                    },
                    ...
                  ]
                },
                ...
              ]
            ```

        - POST `/interview/sentence`
            - creates single sentence record linked with provided book id
            - as body we
              send [CreateSingleSentenceRequest.java](src%2Fmain%2Fjava%2Fcom%2Finterview%2Fmodel%2FCreateSingleSentenceRequest.java)
              which has parameters bookId, value (sentence value), wordCount
          ```
              {
                 "bookId": "4714e9c5-1904-4d70-b1b8-ec9148944f94",
                 "value": "This is a sentence from the book.",
                 "wordCount": 6
              }
          ``` 
            - if book id does not exists in DB, it returns error response
        - POST `/interview/book`
            - creates book with list of sentences
            - as body we
              send [BookDto.java](src%2Fmain%2Fjava%2Fcom%2Finterview%2Fmodel%2FBookDto.java) which
              has parameters name and list of sentences
            ```
              {
                  "name":"My Book",
                  "sentences":[
                      {
                          "value":"This is the first sentence.",
                          "wordCount":5
                      },
                      {
                          "value":"This is the second sentence.",
                          "wordCount":5
                      },
                        ...
                  ]
              }
            ``` 

### ERROR HANDLING

In case of some error there was created error handling which return error response to the client

```
{
    "message": "Sentence with provided ID=9db6eeb9-a9b1-4f07-bfb1-22cbf1061d1d not found.",
    "status": "NOT_FOUND"
}
```
