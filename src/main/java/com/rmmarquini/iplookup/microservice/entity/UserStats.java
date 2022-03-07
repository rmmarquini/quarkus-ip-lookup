package com.rmmarquini.iplookup.microservice.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.common.ProjectionFor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.util.Date;

/**
 * @author Rafael Marquini
 *         hello@rmmarquini.dev
 *         --
 */
@MongoEntity(collection = "ip-lookup")
@ProjectionFor(UserStats.class)
@Schema(description = "Store the requested user stats to the API.")
public class UserStats extends PanacheMongoEntityBase {

    @BsonId
    @BsonProperty("_id")
    public ObjectId _id;

    @BsonProperty("ip_address")
    @JsonbProperty("ip_address")
    public String ipAddress;

    @BsonProperty("user_agent")
    @JsonbProperty("user_agent")
    public String userAgent;

    @BsonProperty("display_language")
    @JsonbProperty("display_language")
    public String displayLanguage;

    @BsonProperty("language")
    @JsonbProperty("language")
    public String language;

    @BsonProperty("request_url")
    @JsonbProperty("request_url")
    public String requestURL;

    @BsonProperty("method")
    @JsonbProperty("method")
    public String method;

    @JsonbDateFormat("yyyy/MM/dd HH:mm:ss")
    @BsonProperty("requested_at")
    @JsonbProperty("requested_at")
    @Schema(implementation = String.class, format = "date")
    public Date requestedAt;

    public UserStats() { }

    public ObjectId get_id() { return _id; }

    public void set_id(ObjectId _id) { this._id = _id; }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getDisplayLanguage() {
        return displayLanguage;
    }

    public void setDisplayLanguage(String displayLanguage) {
        this.displayLanguage = displayLanguage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(Date requestedAt) {
        this.requestedAt = requestedAt;
    }

}
