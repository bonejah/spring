package br.com.yts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	private long id;
	private String url;
	private String imdbCode;
	private String title;
	private String title_english;
	private String title_long;
	private String slug;
	private int year;
	private double rating;
	private int runtime;
	private List<Genre> genres;
	private String summary;
	private String description_full;
	private String synopsis;
	private String ytTrailerCode;
	private String language;
	private String mpaRating;
	private String backgroundImage;
	private String backgroundImageOriginal;
	private String smallCoverImage;
	private String mediumCoverImage;
	private String largeCoverImage;
	private String state;
	private List<Torrent> torrents;
	private String dateUploaded;
	private String dateUploadedUnix;

	public Movie() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImdbCode() {
		return imdbCode;
	}

	public void setImdbCode(String imdbCode) {
		this.imdbCode = imdbCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle_english() {
		return title_english;
	}

	public void setTitle_english(String title_english) {
		this.title_english = title_english;
	}

	public String getTitle_long() {
		return title_long;
	}

	public void setTitle_long(String title_long) {
		this.title_long = title_long;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription_full() {
		return description_full;
	}

	public void setDescription_full(String description_full) {
		this.description_full = description_full;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getYtTrailerCode() {
		return ytTrailerCode;
	}

	public void setYtTrailerCode(String ytTrailerCode) {
		this.ytTrailerCode = ytTrailerCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMpaRating() {
		return mpaRating;
	}

	public void setMpaRating(String mpaRating) {
		this.mpaRating = mpaRating;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getBackgroundImageOriginal() {
		return backgroundImageOriginal;
	}

	public void setBackgroundImageOriginal(String backgroundImageOriginal) {
		this.backgroundImageOriginal = backgroundImageOriginal;
	}

	public String getSmallCoverImage() {
		return smallCoverImage;
	}

	public void setSmallCoverImage(String smallCoverImage) {
		this.smallCoverImage = smallCoverImage;
	}

	public String getMediumCoverImage() {
		return mediumCoverImage;
	}

	public void setMediumCoverImage(String mediumCoverImage) {
		this.mediumCoverImage = mediumCoverImage;
	}

	public String getLargeCoverImage() {
		return largeCoverImage;
	}

	public void setLargeCoverImage(String largeCoverImage) {
		this.largeCoverImage = largeCoverImage;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Torrent> getTorrents() {
		return torrents;
	}

	public void setTorrents(List<Torrent> torrents) {
		this.torrents = torrents;
	}

	public String getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(String dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public String getDateUploadedUnix() {
		return dateUploadedUnix;
	}

	public void setDateUploadedUnix(String dateUploadedUnix) {
		this.dateUploadedUnix = dateUploadedUnix;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", url=" + url + ", imdbCode=" + imdbCode + ", title=" + title + ", title_english="
				+ title_english + ", title_long=" + title_long + ", slug=" + slug + ", year=" + year + ", rating="
				+ rating + ", runtime=" + runtime + ", genres=" + genres + ", summary=" + summary
				+ ", description_full=" + description_full + ", synopsis=" + synopsis + ", ytTrailerCode="
				+ ytTrailerCode + ", language=" + language + ", mpaRating=" + mpaRating + ", backgroundImage="
				+ backgroundImage + ", backgroundImageOriginal=" + backgroundImageOriginal + ", smallCoverImage="
				+ smallCoverImage + ", mediumCoverImage=" + mediumCoverImage + ", largeCoverImage=" + largeCoverImage
				+ ", state=" + state + ", torrents=" + torrents + ", dateUploaded=" + dateUploaded
				+ ", dateUploadedUnix=" + dateUploadedUnix + "]";
	}

}
