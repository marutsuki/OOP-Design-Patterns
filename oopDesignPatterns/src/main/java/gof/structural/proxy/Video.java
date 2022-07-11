package gof.structural.proxy;

import lombok.Getter;

import java.util.UUID;

public record Video(UUID uuid, String name, String creator, int duration) { }
