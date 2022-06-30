package gof.structural.proxy;

import lombok.Getter;

import java.util.UUID;

@Getter
public record Video(UUID uuid, String name, String creator, int duration) { }
