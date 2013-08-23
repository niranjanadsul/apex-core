/*
 *  Copyright (c) 2012-2013 Malhar, Inc.
 *  All Rights Reserved.
 */
package com.datatorrent.stram.security;

import com.datatorrent.stram.security.StramDelegationTokenIdentifier;

import org.apache.hadoop.security.token.delegation.AbstractDelegationTokenSecretManager;

/**
 * <p>StramDelegationTokenManager class.</p>
 *
 * @author Pramod Immaneni <pramod@datatorrent.com>
 * @since 0.3.2
 */
public class StramDelegationTokenManager extends AbstractDelegationTokenSecretManager<StramDelegationTokenIdentifier>
{

  public StramDelegationTokenManager(long delegationKeyUpdateInterval, long delegationTokenMaxLifetime, long delegationTokenRenewInterval,
                                                                  long delegationTokenRemoverScanInterval) {
    super(delegationKeyUpdateInterval,delegationTokenMaxLifetime,delegationTokenRenewInterval,delegationTokenRemoverScanInterval);
  }

  public void addIdentifier(StramDelegationTokenIdentifier identifier) {
    createPassword(identifier);
  }

  @Override
  public StramDelegationTokenIdentifier createIdentifier()
  {
    return new StramDelegationTokenIdentifier();
  }

}