package gof.structural.proxy;

import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.UUID;

@Log4j2
public class ThirdPartyVideoPlatformApi {
    /**
     * Imagine that this class has many properties and implies much overhead for your heap space.
     */
    public ThirdPartyVideoPlatformApi() {}

    public void uploadVideo(Video video) {
        log.info("Video has been uploaded");
    }
    public void updateVideo(UUID id, Map<String, Object> update) {
        log.info("Updating properties of video {} with values {}", id, update.toString());
    }
    public void deleteVideo(UUID id) {
        log.info("Deleting video with id: {}", id);
    }
}
