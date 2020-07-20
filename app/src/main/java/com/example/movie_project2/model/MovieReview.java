package com.example.movie_project2.model;

import java.util.List;

    public class MovieReview {

        /**
         * id : 8619
         * page : 1
         * results : [{"author":"John Chard","content":"For England, for home, and for the prize!  \r\n\r\nMaster and Commander: The Far Side of the World is directed by Peter Weir, it stars Russell Crowe as Jack Aubrey and Paul Bettany as Stephen Maturin. It is spliced from various novels in the Aubrey\u2013Maturin series written by Patrick O'Brian. The film takes place during 1805, during the Napoleonic Wars and finds Captain Jack Aubrey and the crew of British frigate HMS Surprise ordered to intercept, destroy or take as a prize the French privateer Acheron. But the Acheron (The Phantom as the crew of the Surprise call her) is no ordinary ship, and her Captain is smart. So Lucky Jack has his work cut out; not only in the pursuit of the Acheron, but in harmonising the crew under his command. Especially his loyal and trusting friend Stephen.\r\n\r\nIt's pretty evident within the first few minutes of Master & Commander that this is no standard blockbusting naval based war movie. If you are after, or was expecting, a wave to wave Bruckheimer carnage a-like piece, well you best, or should have, stay(ed) away. For this is a Peter Weir movie, in fact this is a Peter Weir \"period\" movie, where attention to details and character dynamics are the order of the day. There's battle action here for sure, beginning and end, and terrific they are too, as first cannonballs crack and splinter their targets (note the sound work here), and later as blade meets blade - it's exhilarating stuff alright. However, this is more interested in palpable tension, both on deck and on the waves. Threat is never far away, again, this is is covered by the impending duel with the Acheron and Aubrey's tactical pursuit/escape of her. As the Aubrey machinations unfurl, the crew give us a series of character dramas to involve us in the make up of a man-o-war's personnel. How different classes and males (there's not one female in the film) of all ages have to work together as one efficient unit in order to survive and triumph. Except for an interlude spent on the lusciously filmed Galapagos Island (Russell Boyd Best Cinematography Academy Award Winner), the film is set 99% of the time out at sea, on a cramped ship, this tells you that Weir is interested in telling a character driven story, one that is cloaked in realism above all else.\r\n\r\nThe teaming of Weir with the highly rated O'Brian material looked a good one, and to someone like me who has never read an O'Brian novel, it is. Unsurprisingly many of O'Brian's fans have been upset by either the stuff missing in the film, the stuff put in to fully form Weir's vision of the characters, or for Crowe not being Pugwashy enough. These complaints were inevitable since they come with practically every adaptation of novels these days. It should be noted, though, that Weir was very much a fan of O'Brian, and in fact always felt inspired by the tight intricate detail of his writings. What of the author himself? Well he passed away three years before the film was released, but he had always envisaged Charlton Heston for the role of Aubrey. So, who in the modern era comes closest to Heston's physical presence on screen, why Russell Crowe of course. Who not only brings that to the character, but also depth, because Aubrey comes with many traits. Strength, honour, stubbornness, leadership and loyalty are a given for a Captain on the high seas. Yet Aubrey is also vulnerable, self aware, playful, knows his limitations and is able to laugh at himself. Crowe peels off each layer and delivers a high quality performance - from our first encounter with Crowe as Aubrey, the realism so loved by Weir is given a shot in the arm - and it stays throughout the movie.\r\n\r\nSo an excellent piece of casting then, as is that of Paul Bettany as ships surgeon, science and nature lover, and best pal of the Captain, Stephen Maturin. Bettany and Crowe had formed a friendship on 2001's A Beautiful Mind, where their on screen chemistry lifted an already fine film, to an even better one. So it be here also. Stephen & Jack's relationship is the core of the piece, two very different men yet as tight as two peas in a pod, with Stephen serving as the code breaker for the audience as sea talk and tactical intrigue weaves in and out of the story. It's there where Bettany excels, for he not only has us believing in this warm (platonic) friendship, he's also got us rooting for him since he is in essence the odd man out on this ship. Our sympathy is firmly with him, our friendly rebel if you please. Of the rest there's note worthy turns from Billy Boyd, James D'Arcy & Edward Woodall, while Lee Ingleby gives a really heartfelt and emotionally engaging turn as the haunted Hollom.\r\n\r\nThe film is not without flaws, though. The pace of the piece does slip from time to time, while the talky middle section may stretch the patience of some, and the film isn't long enough to give the main characters some back story for the audience to work off. Yet it's still a terrific movie, ripe with intelligence and interesting characterisations, and boasting enough adrenalin, humour and upset to fill out a big budgeted 1950s historical epic. So get on board folks, for this is quality film making and it demands to be seen via the best format available. 9/10","id":"5c43bf3bc3a36819fd236996","url":"https://www.themoviedb.org/review/5c43bf3bc3a36819fd236996"},{"author":"narrator56","content":"This is a rousing sea yarn with great camera work, but it also shows comraderie and relationships in a realistic way on board a British fighting ship.\r\n\r\nAs happens sometimes but not always, I enjoyed this movie more than I liked the book it was based upon. O'Brian has written a lot of great sea tales, but this one confused me. I felt like checking to see if the pages were in the correct order. The story seems simplified in this adaptation. (Some may say that is not a good thing!)\r\n\r\nThe first several minutes of the film move the viewer around the ship, and I felt like It was a realistic representation of what it was like to sail on it. The creaking and other ever-present noises, the tight spaces allotted to the crew, all helped me feel like I knew what it was like more than just reading about it.\r\n\r\nThere are a lot of characters aboard ship, so out of necessity some of them never really developed, but even the glimpses we get of them here and there illustrate that they are people, not stereotypes. There were a few rather unlikely plot turns later on in the film, but by then I was drawn into the story and right there with the crew, so I forgave them.  I have watched Master and Commander twice so far, and wouldn't be averse to seeing it again.","id":"5e88572cd55c3d0017512a35","url":"https://www.themoviedb.org/review/5e88572cd55c3d0017512a35"}]
         * total_pages : 1
         * total_results : 2
         */

        private int id;
        private int page;
        private int total_pages;
        private int total_results;
        private List<ResultsBean> results;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public int getTotal_results() {
            return total_results;
        }

        public void setTotal_results(int total_results) {
            this.total_results = total_results;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * author : John Chard
             * content : For England, for home, and for the prize!

             Master and Commander: The Far Side of the World is directed by Peter Weir, it stars Russell Crowe as Jack Aubrey and Paul Bettany as Stephen Maturin. It is spliced from various novels in the Aubrey–Maturin series written by Patrick O'Brian. The film takes place during 1805, during the Napoleonic Wars and finds Captain Jack Aubrey and the crew of British frigate HMS Surprise ordered to intercept, destroy or take as a prize the French privateer Acheron. But the Acheron (The Phantom as the crew of the Surprise call her) is no ordinary ship, and her Captain is smart. So Lucky Jack has his work cut out; not only in the pursuit of the Acheron, but in harmonising the crew under his command. Especially his loyal and trusting friend Stephen.

             It's pretty evident within the first few minutes of Master & Commander that this is no standard blockbusting naval based war movie. If you are after, or was expecting, a wave to wave Bruckheimer carnage a-like piece, well you best, or should have, stay(ed) away. For this is a Peter Weir movie, in fact this is a Peter Weir "period" movie, where attention to details and character dynamics are the order of the day. There's battle action here for sure, beginning and end, and terrific they are too, as first cannonballs crack and splinter their targets (note the sound work here), and later as blade meets blade - it's exhilarating stuff alright. However, this is more interested in palpable tension, both on deck and on the waves. Threat is never far away, again, this is is covered by the impending duel with the Acheron and Aubrey's tactical pursuit/escape of her. As the Aubrey machinations unfurl, the crew give us a series of character dramas to involve us in the make up of a man-o-war's personnel. How different classes and males (there's not one female in the film) of all ages have to work together as one efficient unit in order to survive and triumph. Except for an interlude spent on the lusciously filmed Galapagos Island (Russell Boyd Best Cinematography Academy Award Winner), the film is set 99% of the time out at sea, on a cramped ship, this tells you that Weir is interested in telling a character driven story, one that is cloaked in realism above all else.

             The teaming of Weir with the highly rated O'Brian material looked a good one, and to someone like me who has never read an O'Brian novel, it is. Unsurprisingly many of O'Brian's fans have been upset by either the stuff missing in the film, the stuff put in to fully form Weir's vision of the characters, or for Crowe not being Pugwashy enough. These complaints were inevitable since they come with practically every adaptation of novels these days. It should be noted, though, that Weir was very much a fan of O'Brian, and in fact always felt inspired by the tight intricate detail of his writings. What of the author himself? Well he passed away three years before the film was released, but he had always envisaged Charlton Heston for the role of Aubrey. So, who in the modern era comes closest to Heston's physical presence on screen, why Russell Crowe of course. Who not only brings that to the character, but also depth, because Aubrey comes with many traits. Strength, honour, stubbornness, leadership and loyalty are a given for a Captain on the high seas. Yet Aubrey is also vulnerable, self aware, playful, knows his limitations and is able to laugh at himself. Crowe peels off each layer and delivers a high quality performance - from our first encounter with Crowe as Aubrey, the realism so loved by Weir is given a shot in the arm - and it stays throughout the movie.

             So an excellent piece of casting then, as is that of Paul Bettany as ships surgeon, science and nature lover, and best pal of the Captain, Stephen Maturin. Bettany and Crowe had formed a friendship on 2001's A Beautiful Mind, where their on screen chemistry lifted an already fine film, to an even better one. So it be here also. Stephen & Jack's relationship is the core of the piece, two very different men yet as tight as two peas in a pod, with Stephen serving as the code breaker for the audience as sea talk and tactical intrigue weaves in and out of the story. It's there where Bettany excels, for he not only has us believing in this warm (platonic) friendship, he's also got us rooting for him since he is in essence the odd man out on this ship. Our sympathy is firmly with him, our friendly rebel if you please. Of the rest there's note worthy turns from Billy Boyd, James D'Arcy & Edward Woodall, while Lee Ingleby gives a really heartfelt and emotionally engaging turn as the haunted Hollom.

             The film is not without flaws, though. The pace of the piece does slip from time to time, while the talky middle section may stretch the patience of some, and the film isn't long enough to give the main characters some back story for the audience to work off. Yet it's still a terrific movie, ripe with intelligence and interesting characterisations, and boasting enough adrenalin, humour and upset to fill out a big budgeted 1950s historical epic. So get on board folks, for this is quality film making and it demands to be seen via the best format available. 9/10
             * id : 5c43bf3bc3a36819fd236996
             * url : https://www.themoviedb.org/review/5c43bf3bc3a36819fd236996
             */

            private String author;
            private String content;
            private String id;
            private String url;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

