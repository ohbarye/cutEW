$ ->
	# 交代制変更時
	$('input[name=shiftSystem]').change ->
		showShiftDetail($(this).val())
		@	
		
	
showShiftDetail = (display) ->
	if parseBool(display)
		$('#shiftDetail').show()
	else
		$('#shiftDetail').hide()
		

parseBool = (value) ->
	if /^(true|on|yes|1)$/.test(value)
		true
	else if /^(false|off|no|0)$/.test(value)
		false