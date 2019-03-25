package br.com.yts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Torrent {

	private String url;
	private String hash;
	private String quality;
	private String type;
	private int seeds;
	private int peers;
	private String size;
	private long sizeBytes;
	private String dateUploaded;
	private String dateUploadedUnix;

	public Torrent() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeeds() {
		return seeds;
	}

	public void setSeeds(int seeds) {
		this.seeds = seeds;
	}

	public int getPeers() {
		return peers;
	}

	public void setPeers(int peers) {
		this.peers = peers;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getSizeBytes() {
		return sizeBytes;
	}

	public void setSizeBytes(long sizeBytes) {
		this.sizeBytes = sizeBytes;
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
		return "Torrent [url=" + url + ", hash=" + hash + ", quality=" + quality + ", type=" + type + ", seeds=" + seeds
				+ ", peers=" + peers + ", size=" + size + ", sizeBytes=" + sizeBytes + ", dateUploaded=" + dateUploaded
				+ ", dateUploadedUnix=" + dateUploadedUnix + "]";
	}

}
