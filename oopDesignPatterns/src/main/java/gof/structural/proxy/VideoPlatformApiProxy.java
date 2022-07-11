package gof.structural.proxy;

import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.UUID;

@Log4j2
public class VideoPlatformApiProxy {
    private static VideoPlatformApiProxy instance;
    private ThirdPartyVideoPlatformApi thirdPartyVideoPlatformApi;

    private VideoPlatformApiProxy() {}

    public static VideoPlatformApiProxy getInstance() {
        if (instance == null) {
            instance = new VideoPlatformApiProxy();
        }
        return instance;
    }

    private ThirdPartyVideoPlatformApi getThirdPartyVideoPlatformApi() {
        /**
         * Lazy initialization of heavyweight service object to maximize heap space.
         */
        if (this.thirdPartyVideoPlatformApi == null) {
            this.thirdPartyVideoPlatformApi = new ThirdPartyVideoPlatformApi();
        }
        return this.thirdPartyVideoPlatformApi;
    }

    public void uploadVideo(Video video) {
        /**
         * The proxy can add additional functionality, perhaps we want more verbose logging than what the software
         * came with
         */
        log.info("Uploading video { name: {}, length: {} sec, creator: {} }", video.name(), video.duration(), video.creator());
        this.thirdPartyVideoPlatformApi.uploadVideo(video);
    }

    public void updateVideo(UUID id, Map<String, Object> update) {
        /**
         * The proxy can also provide access control on different granularity levels
         * For example, the API provided does not restrict what can be updated about a video.
         * But we might want to prevent our users from updating the creator name.
         */
        if (update.containsKey("creator")) {
            throw new RuntimeException("Illegal update of creator");
        }
        this.thirdPartyVideoPlatformApi.updateVideo(id, update);
    }

    /**
     * We can also provide access control in the form of completely disabling visibility of a functionality
     * provided by the original service object.
     *
     * In this case, we are not providing the user with deleteVideo()
     */
}
