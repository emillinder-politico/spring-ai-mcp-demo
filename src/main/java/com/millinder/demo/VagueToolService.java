package com.millinder.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VagueToolService implements ExposedTool {
    private final Logger logger = LoggerFactory.getLogger(VagueToolService.class);

    @Tool(name = "legislation_search",
            description = "Search for government dealings. Returns metadata and document snippet previews. Automatically fetches all results")
    public SearchResult search(
            @ToolParam(description = "query") String query,
            @ToolParam(description = "Start of day time in (YYYY-MM-DDTHH:mm:ss.SSSZ) format") String fromDate,
            @ToolParam(description = "End of day time in (YYYY-MM-DDTHH:mm:ss.SSSZ) format") String toDate) {
        logger.info("Called with: {} ({} - {})", query, fromDate, toDate);
        return new SearchResult(List.of(
                new SearchDocument("faq101", "FAQ-101 Dogs", "Dogs have tails and teeth."),
                new SearchDocument("faq102", "FAQ-102 Fishes", "Fish have tails and gills.")
        )
        );
    }

    public class SearchResult {
        List<SearchDocument> legislations;

        public SearchResult(List<SearchDocument> legislations) {
            this.legislations = legislations;
        }

        public List<SearchDocument> getLegislations() {
            return legislations;
        }
    }

    public class SearchDocument {
        private String id;
        private String title;
        private String publisher = "Eric";
        private String publishDate;
        private String tease;
        private String url;

        public SearchDocument(String id, String title, String tease) {
            this.id = id;
            this.title = title;
            this.tease = tease;

            publishDate = new Date(System.currentTimeMillis() - 3600 * 24 * 1).toString();
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public String getTease() {
            return tease;
        }

        public String getUrl() {
            return url;
        }
    }
}
