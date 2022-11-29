/*
 * Copyright (c) 2002-2022, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.pluginwizard.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;

/**
 * This class provides instances management methods (create, find, ...) for Model objects
 */
public final class ModelHome
{
    // Static variable pointed at the DAO instance
    private static IModelDAO _dao = SpringContextService.getBean( "pluginwizard.modelDAO" );
    private static Plugin _plugin = PluginService.getPlugin( "pluginwizard" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private ModelHome( )
    {
    }

    /**
     * Check if a plugin already exists
     * 
     * @param strPluginName
     *            The plugin name
     * @return -1 if not exists, otherwise the plugin id
     */
    public static int exists( String strPluginName )
    {
        for ( Model model : _dao.selectModelsList( _plugin ) )
        {
            if ( model.getName( ).equals( strPluginName ) )
            {
                return model.getIdPlugin( );
            }
        }

        return -1;
    }

    /**
     * Create an instance of the model class
     * 
     * @param model
     *            The instance of the Model which contains the informations to store
     * @return The instance of model which has been created with its primary key.
     */
    public static Model create( Model model )
    {
        _dao.insert( model, _plugin );

        return model;
    }

    /**
     * Update of the model which is specified in parameter
     * 
     * @param model
     *            The instance of the Model which contains the data to store
     * @return The instance of the model which has been updated
     */
    public static Model update( Model model )
    {
        _dao.store( model, _plugin );

        return model;
    }

    /**
     * Remove the model whose identifier is specified in parameter
     * 
     * @param nModelId
     *            The model Id
     */
    public static void remove( int nModelId )
    {
        _dao.delete( nModelId, _plugin );
    }

    // /////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a model whose identifier is specified in parameter
     * 
     * @param nKey
     *            The model primary key
     * @return an instance of Model
     */
    public static Model findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin );
    }
}
