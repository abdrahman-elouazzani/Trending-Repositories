# Trending-Repositories
A small app that will list the most starred Github repos that were created in the last 30 days. You'll be fetching the sorted JSON data directly from the Github API .<br/>

## Features
- As a User you will be able to list the most starred Github repos that were created in the last 30 days.
- As a User you will be able to see the results as a list. One repository per row.
- As a User you will be able to see for each repo/row the following details :
  1. `Repository name.`
  2. `Repository description.`
  3. `Numbers of stars for the repo.`
  4. `Username and avatar of the owner.`
- As a User you will be able to keep scrolling and new results should appear (pagination)

## Installation
Clone this repository and import into **Android Studio**
```bash
git clone git@github.com:wolox/Trending-Repositories.git
```
##  Libraries Used
- The Front-End Using [the Material Design](https://material.io/design/) library contains : 
  1. [BottomNavigationView](https://material.io/components/bottom-navigation) component to navigated between the Trending and Setting.
  2. [RecyclerView](https://material.io/components/lists) to list the items (repository) on each row with Layout.
 ...<br/>
 
- The Back-end : call the api rest github repositories request using :
  1. [The Volley library](https://developer.android.com/training/volley) to create the Request Queue.
  2. [The library Gson](https://github.com/google/gson) to create the JSON-OBJECT-REAUEST and JSON-ARRAY, JSON-OBECT for Parsing the data.
  ... <br/>

## The Previews 
![Screenshot_2020-08-08-17-09-01](https://user-images.githubusercontent.com/40376977/89733274-5a905700-da4c-11ea-90ea-c1b5f016bf03.png)
![Screenshot_2020-08-08-17-09-06](https://user-images.githubusercontent.com/40376977/89733277-5c5a1a80-da4c-11ea-9ea2-fd16e9eb09e3.png)
![Screenshot_2020-08-08-17-09-42](https://user-images.githubusercontent.com/40376977/89733278-5e23de00-da4c-11ea-82df-fde3c3a24864.png)
![Screenshot_2020-08-08-17-09-45](https://user-images.githubusercontent.com/40376977/89733279-5feda180-da4c-11ea-9c4d-06ff394f524c.png)
