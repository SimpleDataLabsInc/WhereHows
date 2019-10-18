package com.linkedin.common.urn;

import com.linkedin.common.FabricType;

public final class FabricUrn extends Urn {

  public static final String ENTITY_TYPE = "fabric";

  private static final String CONTENT_FORMAT = "(%s,%s)";

  private final String nameEntity;

  private final FabricType fabricType;

  public FabricUrn(String name, FabricType fabricType) {
    super(ENTITY_TYPE, String.format(CONTENT_FORMAT, name, fabricType.name()));
    this.nameEntity = name;
    this.fabricType = fabricType;
  }

  public String getNameEntity() {
    return nameEntity;
  }

  public FabricType getFabricType() {
    return fabricType;
  }

  public static FabricUrn createFromString(String rawUrn) {

  }
}
