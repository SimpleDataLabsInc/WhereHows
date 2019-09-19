package hive.metastore;
import com.facebook.fb303.fb_status;
import org.apache.hadoop.hive.metastore.api.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

import java.util.List;
import java.util.Map;

public class HiveMetastoreImpl implements ThriftHiveMetastore.Iface {
    @Override
    public String getMetaConf(String key) throws MetaException, TException {
        return null;
    }

    @Override
    public void setMetaConf(String key, String value) throws MetaException, TException {

    }

    @Override
    public void create_catalog(CreateCatalogRequest catalog) throws AlreadyExistsException, InvalidObjectException, MetaException, TException {

    }

    @Override
    public void alter_catalog(AlterCatalogRequest rqst) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {

    }

    @Override
    public GetCatalogResponse get_catalog(GetCatalogRequest catName) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public GetCatalogsResponse get_catalogs() throws MetaException, TException {
        return null;
    }

    @Override
    public void drop_catalog(DropCatalogRequest catName) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {

    }

    @Override
    public void create_database(Database database) throws AlreadyExistsException, InvalidObjectException, MetaException, TException {

    }

    @Override
    public Database get_database(String name) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public void drop_database(String name, boolean deleteData, boolean cascade) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {

    }

    @Override
    public List<String> get_databases(String pattern) throws MetaException, TException {
        return null;
    }

    @Override
    public List<String> get_all_databases() throws MetaException, TException {
        return null;
    }

    @Override
    public void alter_database(String dbname, Database db) throws MetaException, NoSuchObjectException, TException {

    }

    @Override
    public Type get_type(String name) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public boolean create_type(Type type) throws AlreadyExistsException, InvalidObjectException, MetaException, TException {
        return false;
    }

    @Override
    public boolean drop_type(String type) throws MetaException, NoSuchObjectException, TException {
        return false;
    }

    @Override
    public Map<String, Type> get_type_all(String name) throws MetaException, TException {
        return null;
    }

    @Override
    public List<FieldSchema> get_fields(String db_name, String table_name) throws MetaException, UnknownTableException, UnknownDBException, TException {
        return null;
    }

    @Override
    public List<FieldSchema> get_fields_with_environment_context(String db_name, String table_name, EnvironmentContext environment_context) throws MetaException, UnknownTableException, UnknownDBException, TException {
        return null;
    }

    @Override
    public List<FieldSchema> get_schema(String db_name, String table_name) throws MetaException, UnknownTableException, UnknownDBException, TException {
        return null;
    }

    @Override
    public List<FieldSchema> get_schema_with_environment_context(String db_name, String table_name, EnvironmentContext environment_context) throws MetaException, UnknownTableException, UnknownDBException, TException {
        return null;
    }

    @Override
    public void create_table(Table tbl) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException, TException {

    }

    @Override
    public void create_table_with_environment_context(Table tbl, EnvironmentContext environment_context) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException, TException {

    }

    @Override
    public void create_table_with_constraints(Table tbl, List<SQLPrimaryKey> primaryKeys, List<SQLForeignKey> foreignKeys, List<SQLUniqueConstraint> uniqueConstraints, List<SQLNotNullConstraint> notNullConstraints, List<SQLDefaultConstraint> defaultConstraints, List<SQLCheckConstraint> checkConstraints) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException, TException {

    }

    @Override
    public void drop_constraint(DropConstraintRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void add_primary_key(AddPrimaryKeyRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void add_foreign_key(AddForeignKeyRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void add_unique_constraint(AddUniqueConstraintRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void add_not_null_constraint(AddNotNullConstraintRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void add_default_constraint(AddDefaultConstraintRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void add_check_constraint(AddCheckConstraintRequest req) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void drop_table(String dbname, String name, boolean deleteData) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void drop_table_with_environment_context(String dbname, String name, boolean deleteData, EnvironmentContext environment_context) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void truncate_table(String dbName, String tableName, List<String> partNames) throws MetaException, TException {

    }

    @Override
    public List<String> get_tables(String db_name, String pattern) throws MetaException, TException {
        return null;
    }

    @Override
    public List<String> get_tables_by_type(String db_name, String pattern, String tableType) throws MetaException, TException {
        return null;
    }

    @Override
    public List<String> get_materialized_views_for_rewriting(String db_name) throws MetaException, TException {
        return null;
    }

    @Override
    public List<TableMeta> get_table_meta(String db_patterns, String tbl_patterns, List<String> tbl_types) throws MetaException, TException {
        return null;
    }

    @Override
    public List<String> get_all_tables(String db_name) throws MetaException, TException {
        return null;
    }

    @Override
    public Table get_table(String dbname, String tbl_name) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public List<Table> get_table_objects_by_name(String dbname, List<String> tbl_names) throws TException {
        return null;
    }

    @Override
    public GetTableResult get_table_req(GetTableRequest req) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public GetTablesResult get_table_objects_by_name_req(GetTablesRequest req) throws MetaException, InvalidOperationException, UnknownDBException, TException {
        return null;
    }

    @Override
    public Materialization get_materialization_invalidation_info(CreationMetadata creation_metadata, String validTxnList) throws MetaException, InvalidOperationException, UnknownDBException, TException {
        return null;
    }

    @Override
    public void update_creation_metadata(String catName, String dbname, String tbl_name, CreationMetadata creation_metadata) throws MetaException, InvalidOperationException, UnknownDBException, TException {

    }

    @Override
    public List<String> get_table_names_by_filter(String dbname, String filter, short max_tables) throws MetaException, InvalidOperationException, UnknownDBException, TException {
        return null;
    }

    @Override
    public void alter_table(String dbname, String tbl_name, Table new_tbl) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public void alter_table_with_environment_context(String dbname, String tbl_name, Table new_tbl, EnvironmentContext environment_context) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public void alter_table_with_cascade(String dbname, String tbl_name, Table new_tbl, boolean cascade) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public Partition add_partition(Partition new_part) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public Partition add_partition_with_environment_context(Partition new_part, EnvironmentContext environment_context) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public int add_partitions(List<Partition> new_parts) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return 0;
    }

    @Override
    public int add_partitions_pspec(List<PartitionSpec> new_parts) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return 0;
    }

    @Override
    public Partition append_partition(String db_name, String tbl_name, List<String> part_vals) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public AddPartitionsResult add_partitions_req(AddPartitionsRequest request) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public Partition append_partition_with_environment_context(String db_name, String tbl_name, List<String> part_vals, EnvironmentContext environment_context) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public Partition append_partition_by_name(String db_name, String tbl_name, String part_name) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public Partition append_partition_by_name_with_environment_context(String db_name, String tbl_name, String part_name, EnvironmentContext environment_context) throws InvalidObjectException, AlreadyExistsException, MetaException, TException {
        return null;
    }

    @Override
    public boolean drop_partition(String db_name, String tbl_name, List<String> part_vals, boolean deleteData) throws NoSuchObjectException, MetaException, TException {
        return false;
    }

    @Override
    public boolean drop_partition_with_environment_context(String db_name, String tbl_name, List<String> part_vals, boolean deleteData, EnvironmentContext environment_context) throws NoSuchObjectException, MetaException, TException {
        return false;
    }

    @Override
    public boolean drop_partition_by_name(String db_name, String tbl_name, String part_name, boolean deleteData) throws NoSuchObjectException, MetaException, TException {
        return false;
    }

    @Override
    public boolean drop_partition_by_name_with_environment_context(String db_name, String tbl_name, String part_name, boolean deleteData, EnvironmentContext environment_context) throws NoSuchObjectException, MetaException, TException {
        return false;
    }

    @Override
    public DropPartitionsResult drop_partitions_req(DropPartitionsRequest req) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public Partition get_partition(String db_name, String tbl_name, List<String> part_vals) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public Partition exchange_partition(Map<String, String> partitionSpecs, String source_db, String source_table_name, String dest_db, String dest_table_name) throws MetaException, NoSuchObjectException, InvalidObjectException, InvalidInputException, TException {
        return null;
    }

    @Override
    public List<Partition> exchange_partitions(Map<String, String> partitionSpecs, String source_db, String source_table_name, String dest_db, String dest_table_name) throws MetaException, NoSuchObjectException, InvalidObjectException, InvalidInputException, TException {
        return null;
    }

    @Override
    public Partition get_partition_with_auth(String db_name, String tbl_name, List<String> part_vals, String user_name, List<String> group_names) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public Partition get_partition_by_name(String db_name, String tbl_name, String part_name) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public List<Partition> get_partitions(String db_name, String tbl_name, short max_parts) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public List<Partition> get_partitions_with_auth(String db_name, String tbl_name, short max_parts, String user_name, List<String> group_names) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public List<PartitionSpec> get_partitions_pspec(String db_name, String tbl_name, int max_parts) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public List<String> get_partition_names(String db_name, String tbl_name, short max_parts) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public PartitionValuesResponse get_partition_values(PartitionValuesRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public List<Partition> get_partitions_ps(String db_name, String tbl_name, List<String> part_vals, short max_parts) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public List<Partition> get_partitions_ps_with_auth(String db_name, String tbl_name, List<String> part_vals, short max_parts, String user_name, List<String> group_names) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public List<String> get_partition_names_ps(String db_name, String tbl_name, List<String> part_vals, short max_parts) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public List<Partition> get_partitions_by_filter(String db_name, String tbl_name, String filter, short max_parts) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public List<PartitionSpec> get_part_specs_by_filter(String db_name, String tbl_name, String filter, int max_parts) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public PartitionsByExprResult get_partitions_by_expr(PartitionsByExprRequest req) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public int get_num_partitions_by_filter(String db_name, String tbl_name, String filter) throws MetaException, NoSuchObjectException, TException {
        return 0;
    }

    @Override
    public List<Partition> get_partitions_by_names(String db_name, String tbl_name, List<String> names) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public void alter_partition(String db_name, String tbl_name, Partition new_part) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public void alter_partitions(String db_name, String tbl_name, List<Partition> new_parts) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public void alter_partitions_with_environment_context(String db_name, String tbl_name, List<Partition> new_parts, EnvironmentContext environment_context) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public void alter_partition_with_environment_context(String db_name, String tbl_name, Partition new_part, EnvironmentContext environment_context) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public void rename_partition(String db_name, String tbl_name, List<String> part_vals, Partition new_part) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public boolean partition_name_has_valid_characters(List<String> part_vals, boolean throw_exception) throws MetaException, TException {
        return false;
    }

    @Override
    public String get_config_value(String name, String defaultValue) throws ConfigValSecurityException, TException {
        return null;
    }

    @Override
    public List<String> partition_name_to_vals(String part_name) throws MetaException, TException {
        return null;
    }

    @Override
    public Map<String, String> partition_name_to_spec(String part_name) throws MetaException, TException {
        return null;
    }

    @Override
    public void markPartitionForEvent(String db_name, String tbl_name, Map<String, String> part_vals, PartitionEventType eventType) throws MetaException, NoSuchObjectException, UnknownDBException, UnknownTableException, UnknownPartitionException, InvalidPartitionException, TException {

    }

    @Override
    public boolean isPartitionMarkedForEvent(String db_name, String tbl_name, Map<String, String> part_vals, PartitionEventType eventType) throws MetaException, NoSuchObjectException, UnknownDBException, UnknownTableException, UnknownPartitionException, InvalidPartitionException, TException {
        return false;
    }

    @Override
    public PrimaryKeysResponse get_primary_keys(PrimaryKeysRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public ForeignKeysResponse get_foreign_keys(ForeignKeysRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public UniqueConstraintsResponse get_unique_constraints(UniqueConstraintsRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public NotNullConstraintsResponse get_not_null_constraints(NotNullConstraintsRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public DefaultConstraintsResponse get_default_constraints(DefaultConstraintsRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public CheckConstraintsResponse get_check_constraints(CheckConstraintsRequest request) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public boolean update_table_column_statistics(ColumnStatistics stats_obj) throws NoSuchObjectException, InvalidObjectException, MetaException, InvalidInputException, TException {
        return false;
    }

    @Override
    public boolean update_partition_column_statistics(ColumnStatistics stats_obj) throws NoSuchObjectException, InvalidObjectException, MetaException, InvalidInputException, TException {
        return false;
    }

    @Override
    public ColumnStatistics get_table_column_statistics(String db_name, String tbl_name, String col_name) throws NoSuchObjectException, MetaException, InvalidInputException, InvalidObjectException, TException {
        return null;
    }

    @Override
    public ColumnStatistics get_partition_column_statistics(String db_name, String tbl_name, String part_name, String col_name) throws NoSuchObjectException, MetaException, InvalidInputException, InvalidObjectException, TException {
        return null;
    }

    @Override
    public TableStatsResult get_table_statistics_req(TableStatsRequest request) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public PartitionsStatsResult get_partitions_statistics_req(PartitionsStatsRequest request) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public AggrStats get_aggr_stats_for(PartitionsStatsRequest request) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public boolean set_aggr_stats_for(SetPartitionsStatsRequest request) throws NoSuchObjectException, InvalidObjectException, MetaException, InvalidInputException, TException {
        return false;
    }

    @Override
    public boolean delete_partition_column_statistics(String db_name, String tbl_name, String part_name, String col_name) throws NoSuchObjectException, MetaException, InvalidObjectException, InvalidInputException, TException {
        return false;
    }

    @Override
    public boolean delete_table_column_statistics(String db_name, String tbl_name, String col_name) throws NoSuchObjectException, MetaException, InvalidObjectException, InvalidInputException, TException {
        return false;
    }

    @Override
    public void create_function(Function func) throws AlreadyExistsException, InvalidObjectException, MetaException, NoSuchObjectException, TException {

    }

    @Override
    public void drop_function(String dbName, String funcName) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void alter_function(String dbName, String funcName, Function newFunc) throws InvalidOperationException, MetaException, TException {

    }

    @Override
    public List<String> get_functions(String dbName, String pattern) throws MetaException, TException {
        return null;
    }

    @Override
    public Function get_function(String dbName, String funcName) throws MetaException, NoSuchObjectException, TException {
        return null;
    }

    @Override
    public GetAllFunctionsResponse get_all_functions() throws MetaException, TException {
        return null;
    }

    @Override
    public boolean create_role(Role role) throws MetaException, TException {
        return false;
    }

    @Override
    public boolean drop_role(String role_name) throws MetaException, TException {
        return false;
    }

    @Override
    public List<String> get_role_names() throws MetaException, TException {
        return null;
    }

    @Override
    public boolean grant_role(String role_name, String principal_name, PrincipalType principal_type, String grantor, PrincipalType grantorType, boolean grant_option) throws MetaException, TException {
        return false;
    }

    @Override
    public boolean revoke_role(String role_name, String principal_name, PrincipalType principal_type) throws MetaException, TException {
        return false;
    }

    @Override
    public List<Role> list_roles(String principal_name, PrincipalType principal_type) throws MetaException, TException {
        return null;
    }

    @Override
    public GrantRevokeRoleResponse grant_revoke_role(GrantRevokeRoleRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public GetPrincipalsInRoleResponse get_principals_in_role(GetPrincipalsInRoleRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public GetRoleGrantsForPrincipalResponse get_role_grants_for_principal(GetRoleGrantsForPrincipalRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public PrincipalPrivilegeSet get_privilege_set(HiveObjectRef hiveObject, String user_name, List<String> group_names) throws MetaException, TException {
        return null;
    }

    @Override
    public List<HiveObjectPrivilege> list_privileges(String principal_name, PrincipalType principal_type, HiveObjectRef hiveObject) throws MetaException, TException {
        return null;
    }

    @Override
    public boolean grant_privileges(PrivilegeBag privileges) throws MetaException, TException {
        return false;
    }

    @Override
    public boolean revoke_privileges(PrivilegeBag privileges) throws MetaException, TException {
        return false;
    }

    @Override
    public GrantRevokePrivilegeResponse grant_revoke_privileges(GrantRevokePrivilegeRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public GrantRevokePrivilegeResponse refresh_privileges(HiveObjectRef objToRefresh, String authorizer, GrantRevokePrivilegeRequest grantRequest) throws MetaException, TException {
        return null;
    }

    @Override
    public List<String> set_ugi(String user_name, List<String> group_names) throws MetaException, TException {
        return null;
    }

    @Override
    public String get_delegation_token(String token_owner, String renewer_kerberos_principal_name) throws MetaException, TException {
        return null;
    }

    @Override
    public long renew_delegation_token(String token_str_form) throws MetaException, TException {
        return 0;
    }

    @Override
    public void cancel_delegation_token(String token_str_form) throws MetaException, TException {

    }

    @Override
    public boolean add_token(String token_identifier, String delegation_token) throws TException {
        return false;
    }

    @Override
    public boolean remove_token(String token_identifier) throws TException {
        return false;
    }

    @Override
    public String get_token(String token_identifier) throws TException {
        return null;
    }

    @Override
    public List<String> get_all_token_identifiers() throws TException {
        return null;
    }

    @Override
    public int add_master_key(String key) throws MetaException, TException {
        return 0;
    }

    @Override
    public void update_master_key(int seq_number, String key) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public boolean remove_master_key(int key_seq) throws TException {
        return false;
    }

    @Override
    public List<String> get_master_keys() throws TException {
        return null;
    }

    @Override
    public GetOpenTxnsResponse get_open_txns() throws TException {
        return null;
    }

    @Override
    public GetOpenTxnsInfoResponse get_open_txns_info() throws TException {
        return null;
    }

    @Override
    public OpenTxnsResponse open_txns(OpenTxnRequest rqst) throws TException {
        return null;
    }

    @Override
    public void abort_txn(AbortTxnRequest rqst) throws NoSuchTxnException, TException {

    }

    @Override
    public void abort_txns(AbortTxnsRequest rqst) throws NoSuchTxnException, TException {

    }

    @Override
    public void commit_txn(CommitTxnRequest rqst) throws NoSuchTxnException, TxnAbortedException, TException {

    }

    @Override
    public void repl_tbl_writeid_state(ReplTblWriteIdStateRequest rqst) throws TException {

    }

    @Override
    public GetValidWriteIdsResponse get_valid_write_ids(GetValidWriteIdsRequest rqst) throws NoSuchTxnException, MetaException, TException {
        return null;
    }

    @Override
    public AllocateTableWriteIdsResponse allocate_table_write_ids(AllocateTableWriteIdsRequest rqst) throws NoSuchTxnException, TxnAbortedException, MetaException, TException {
        return null;
    }

    @Override
    public LockResponse lock(LockRequest rqst) throws NoSuchTxnException, TxnAbortedException, TException {
        return null;
    }

    @Override
    public LockResponse check_lock(CheckLockRequest rqst) throws NoSuchTxnException, TxnAbortedException, NoSuchLockException, TException {
        return null;
    }

    @Override
    public void unlock(UnlockRequest rqst) throws NoSuchLockException, TxnOpenException, TException {

    }

    @Override
    public ShowLocksResponse show_locks(ShowLocksRequest rqst) throws TException {
        return null;
    }

    @Override
    public void heartbeat(HeartbeatRequest ids) throws NoSuchLockException, NoSuchTxnException, TxnAbortedException, TException {

    }

    @Override
    public HeartbeatTxnRangeResponse heartbeat_txn_range(HeartbeatTxnRangeRequest txns) throws TException {
        return null;
    }

    @Override
    public void compact(CompactionRequest rqst) throws TException {

    }

    @Override
    public CompactionResponse compact2(CompactionRequest rqst) throws TException {
        return null;
    }

    @Override
    public ShowCompactResponse show_compact(ShowCompactRequest rqst) throws TException {
        return null;
    }

    @Override
    public void add_dynamic_partitions(AddDynamicPartitions rqst) throws NoSuchTxnException, TxnAbortedException, TException {

    }

    @Override
    public NotificationEventResponse get_next_notification(NotificationEventRequest rqst) throws TException {
        return null;
    }

    @Override
    public CurrentNotificationEventId get_current_notificationEventId() throws TException {
        return null;
    }

    @Override
    public NotificationEventsCountResponse get_notification_events_count(NotificationEventsCountRequest rqst) throws TException {
        return null;
    }

    @Override
    public FireEventResponse fire_listener_event(FireEventRequest rqst) throws TException {
        return null;
    }

    @Override
    public void flushCache() throws TException {

    }

    @Override
    public CmRecycleResponse cm_recycle(CmRecycleRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public GetFileMetadataByExprResult get_file_metadata_by_expr(GetFileMetadataByExprRequest req) throws TException {
        return null;
    }

    @Override
    public GetFileMetadataResult get_file_metadata(GetFileMetadataRequest req) throws TException {
        return null;
    }

    @Override
    public PutFileMetadataResult put_file_metadata(PutFileMetadataRequest req) throws TException {
        return null;
    }

    @Override
    public ClearFileMetadataResult clear_file_metadata(ClearFileMetadataRequest req) throws TException {
        return null;
    }

    @Override
    public CacheFileMetadataResult cache_file_metadata(CacheFileMetadataRequest req) throws TException {
        return null;
    }

    @Override
    public String get_metastore_db_uuid() throws MetaException, TException {
        return null;
    }

    @Override
    public WMCreateResourcePlanResponse create_resource_plan(WMCreateResourcePlanRequest request) throws AlreadyExistsException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMGetResourcePlanResponse get_resource_plan(WMGetResourcePlanRequest request) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMGetActiveResourcePlanResponse get_active_resource_plan(WMGetActiveResourcePlanRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public WMGetAllResourcePlanResponse get_all_resource_plans(WMGetAllResourcePlanRequest request) throws MetaException, TException {
        return null;
    }

    @Override
    public WMAlterResourcePlanResponse alter_resource_plan(WMAlterResourcePlanRequest request) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {
        return null;
    }

    @Override
    public WMValidateResourcePlanResponse validate_resource_plan(WMValidateResourcePlanRequest request) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMDropResourcePlanResponse drop_resource_plan(WMDropResourcePlanRequest request) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {
        return null;
    }

    @Override
    public WMCreateTriggerResponse create_wm_trigger(WMCreateTriggerRequest request) throws AlreadyExistsException, NoSuchObjectException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMAlterTriggerResponse alter_wm_trigger(WMAlterTriggerRequest request) throws NoSuchObjectException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMDropTriggerResponse drop_wm_trigger(WMDropTriggerRequest request) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {
        return null;
    }

    @Override
    public WMGetTriggersForResourePlanResponse get_triggers_for_resourceplan(WMGetTriggersForResourePlanRequest request) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMCreatePoolResponse create_wm_pool(WMCreatePoolRequest request) throws AlreadyExistsException, NoSuchObjectException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMAlterPoolResponse alter_wm_pool(WMAlterPoolRequest request) throws AlreadyExistsException, NoSuchObjectException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMDropPoolResponse drop_wm_pool(WMDropPoolRequest request) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {
        return null;
    }

    @Override
    public WMCreateOrUpdateMappingResponse create_or_update_wm_mapping(WMCreateOrUpdateMappingRequest request) throws AlreadyExistsException, NoSuchObjectException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public WMDropMappingResponse drop_wm_mapping(WMDropMappingRequest request) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {
        return null;
    }

    @Override
    public WMCreateOrDropTriggerToPoolMappingResponse create_or_drop_wm_trigger_to_pool_mapping(WMCreateOrDropTriggerToPoolMappingRequest request) throws AlreadyExistsException, NoSuchObjectException, InvalidObjectException, MetaException, TException {
        return null;
    }

    @Override
    public void create_ischema(ISchema schema) throws AlreadyExistsException, NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void alter_ischema(AlterISchemaRequest rqst) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public ISchema get_ischema(ISchemaName name) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public void drop_ischema(ISchemaName name) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {

    }

    @Override
    public void add_schema_version(SchemaVersion schemaVersion) throws AlreadyExistsException, NoSuchObjectException, MetaException, TException {

    }

    @Override
    public SchemaVersion get_schema_version(SchemaVersionDescriptor schemaVersion) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public SchemaVersion get_schema_latest_version(ISchemaName schemaName) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public List<SchemaVersion> get_schema_all_versions(ISchemaName schemaName) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public void drop_schema_version(SchemaVersionDescriptor schemaVersion) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public FindSchemasByColsResp get_schemas_by_cols(FindSchemasByColsRqst rqst) throws MetaException, TException {
        return null;
    }

    @Override
    public void map_schema_version_to_serde(MapSchemaVersionToSerdeRequest rqst) throws NoSuchObjectException, MetaException, TException {

    }

    @Override
    public void set_schema_version_state(SetSchemaVersionStateRequest rqst) throws NoSuchObjectException, InvalidOperationException, MetaException, TException {

    }

    @Override
    public void add_serde(SerDeInfo serde) throws AlreadyExistsException, MetaException, TException {

    }

    @Override
    public SerDeInfo get_serde(GetSerdeRequest rqst) throws NoSuchObjectException, MetaException, TException {
        return null;
    }

    @Override
    public LockResponse get_lock_materialization_rebuild(String dbName, String tableName, long txnId) throws TException {
        return null;
    }

    @Override
    public boolean heartbeat_lock_materialization_rebuild(String dbName, String tableName, long txnId) throws TException {
        return false;
    }

    @Override
    public void add_runtime_stats(RuntimeStat stat) throws MetaException, TException {

    }

    @Override
    public List<RuntimeStat> get_runtime_stats(GetRuntimeStatsRequest rqst) throws MetaException, TException {
        return null;
    }

    @Override
    public String getName() throws TException {
        return null;
    }

    @Override
    public String getVersion() throws TException {
        return null;
    }

    @Override
    public fb_status getStatus() throws TException {
        return null;
    }

    @Override
    public String getStatusDetails() throws TException {
        return null;
    }

    @Override
    public Map<String, Long> getCounters() throws TException {
        return null;
    }

    @Override
    public long getCounter(String key) throws TException {
        return 0;
    }

    @Override
    public void setOption(String key, String value) throws TException {

    }

    @Override
    public String getOption(String key) throws TException {
        return null;
    }

    @Override
    public Map<String, String> getOptions() throws TException {
        return null;
    }

    @Override
    public String getCpuProfile(int profileDurationInSec) throws TException {
        return null;
    }

    @Override
    public long aliveSince() throws TException {
        return 0;
    }

    @Override
    public void reinitialize() throws TException {

    }

    @Override
    public void shutdown() throws TException {

    }
}
