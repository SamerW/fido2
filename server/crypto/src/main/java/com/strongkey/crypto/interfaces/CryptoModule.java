/**
 * Copyright StrongAuth, Inc. All Rights Reserved.
 *
 * Use of this source code is governed by the Gnu Lesser General Public License 2.3.
 * The license can be found at https://github.com/StrongKey/fido2/LICENSE
 */

package com.strongkey.crypto.interfaces;

import com.strongkey.crypto.utility.CryptoException;
import java.security.PrivateKey;

public interface CryptoModule
{
    
    public PrivateKey getXMLSignatureSigningKey(
                String secret,
                String signingdn) 
            throws 
                CryptoException;

    }
