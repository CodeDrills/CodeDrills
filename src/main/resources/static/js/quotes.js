// const quotesKey = document.querySelector('meta.quotesKey') .content;
//
// fetch("https://quotes15.p.rapidapi.com/quotes/random/?language_code=en", {
//     "method": "GET",
//     "headers": {
//         "x-rapidapi-host": "quotes15.p.rapidapi.com",
//         "x-rapidapi-key": quotesKey
//     }
// })
//     .then(response => response.json())
//     .then(response => {
//         let quote = response.content;
//         let author = response.originator.name;
//         document.querySelector("#fill-quote-div").innerHTML = document.querySelector("#fill-quote-div").innerHTML + `<p id="quote-para">${quote}</p><p id="quote-para">${author}</p>`;
//     })